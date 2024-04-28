package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.Deposit;
import ProducerConsumer.Logger;
import ProducerConsumer.Valuable;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;

  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    while (true)
    {
      ReadTreasureRoom room = treasureRoomDoor.acquireRead();
      int moneyInTotal = 0;
      int index = 0;
      int valuables=room.getSize();

      for(int i=0; i<valuables; i++)
      {
        Valuable gemFromTreasureRoom = room.read(index);
        if (gemFromTreasureRoom == null)
        {
          break;
        }
        else
        {
          moneyInTotal += gemFromTreasureRoom.getValue();
          index++;
          takesTime(1);
        }
      }

      Logger.getInstance().addLog(Thread.currentThread().getName()
          + " has calculated the value of the valuables in the treasure room: $"
          + moneyInTotal);
      treasureRoomDoor.releaseRead(room);
      takesTime(1);
    }
  }

  private void takesTime(int seconds)
  {
    try
    {
      Thread.sleep(seconds * 1000);
    }
    catch (InterruptedException e)
    {/* empty*/ }
  }

}
