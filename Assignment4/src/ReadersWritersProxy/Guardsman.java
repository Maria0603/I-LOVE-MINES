package ReadersWritersProxy;
import ProducerConsumer.Logger;

import java.util.ArrayDeque;
import java.util.Queue;

public class Guardsman implements TreasureRoomDoor
{
  private int readers;
  private int writers;
  private Queue<Thread> queue;
  private TreasureRoom treasureRoom;

  public Guardsman(TreasureRoom treasureRoom)
  {
    readers = 0;
    writers = 0;
    this.treasureRoom = treasureRoom;
    queue = new ArrayDeque<>();
  }

  @Override public synchronized ReadTreasureRoom acquireRead()
  {
    queue.offer(Thread.currentThread());
    while (queue.peek() != Thread.currentThread())
    {
      try
      {
        Logger.getInstance().addLog(
            Thread.currentThread().getName() + " is waiting to READ; "
                + "readers: " + readers + ", writers: " + writers);
        wait();
      }
      catch (InterruptedException e)
      {
        //  ...
      }
    }
    Logger.getInstance().addLog(Thread.currentThread().getName() + " is the first one in the queue for reading; readers: " + readers + ", writers: " + writers);
    while(writers>0)
    {
        try
        {
            Logger.getInstance().addLog(Thread.currentThread().getName() + " is waiting for the writer; readers: " + readers + ", writers: " + writers);
            wait();
        }
        catch(InterruptedException e)
        {
            //
        }
    }
    readers++;
    queue.remove();
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " is READING; " + "readers: "
            + readers + ", writers: " + writers);
    notifyAll();
    return new TreasureRoomReadProxy(treasureRoom);
  }

  @Override public synchronized void releaseRead(ReadTreasureRoom room)
  {
    readers--;
    if(room instanceof  TreasureRoomReadProxy)
    {
        TreasureRoomReadProxy treasureRoomReadProxy=(TreasureRoomReadProxy) room;
        treasureRoomReadProxy.terminate();
    }
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " is releasing the READ; " + "readers: "
            + readers + ", writers: " + writers);
    if (readers == 0)
      notifyAll();
  }

  @Override public synchronized WriteTreasureRoom acquireWrite()
  {
    queue.offer(Thread.currentThread());
    while (queue.peek()!=Thread.currentThread())
    {
      try
      {
          Logger.getInstance().addLog(
              Thread.currentThread().getName() + " is waiting to WRITE; " + "readers: "
                  + readers + ", writers: " + writers);
        wait();
      }
      catch (InterruptedException e)
      {
        //  ...
      }
    }
      Logger.getInstance().addLog(Thread.currentThread().getName() + " is the first one in the queue for writing; readers: " + readers + ", writers: " + writers);

    while(writers>0 || readers>0)
    {
        try
        {
            Logger.getInstance().addLog(
                Thread.currentThread().getName() + " is waiting for everyone to leave; " + "readers: "
                    + readers + ", writers: " + writers);
            wait();
        }
        catch (InterruptedException e)
        {
            //  ...
        }
    }

    writers++;
    queue.remove();
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " is WRITING; " + "readers: "
            + readers + ", writers: " + writers);
    return new TreasureRoomWriteProxy(treasureRoom);
  }

  @Override public synchronized void releaseWrite(WriteTreasureRoom room)
  {
    writers--;
    if(room instanceof TreasureRoomWriteProxy)
    {
        TreasureRoomWriteProxy treasureRoomAddProxy=(TreasureRoomWriteProxy) room;
        treasureRoomAddProxy.terminate();
    }
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " is releasing the WRITE; " + "readers: "
            + readers + ", writers: " + writers);
    notifyAll();
  }

}
