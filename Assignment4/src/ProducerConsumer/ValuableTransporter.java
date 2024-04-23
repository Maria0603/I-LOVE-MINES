package ProducerConsumer;

import ReadersWritersProxy.ReadAddTreasureRoom;
import ReadersWritersProxy.TreasureRoomDoor;

public class ValuableTransporter implements Runnable
{
  private Deposit deposit;
  private ArrayList<Valuable> valuables;
  private TreasureRoomDoor treasureRoomDoor;
  public ValuableTransporter(Deposit deposit, TreasureRoomDoor treasureRoomDoor)
  {
    this.deposit=deposit;
    this.treasureRoomDoor=treasureRoomDoor;
    valuables=new ArrayList<>();
  }
  @Override public void run()
  {
    while (true)
    {
      int random = (int) Math.floor(Math.random() * (200 - 50 + 1) + 50);
      Logger.getInstance().addLog(Thread.currentThread().getName() + " must transport valuables worth at least: " + random);
      while (getTotalValue() < random)
      {
        valuables.add(deposit.extractValuable());
        Logger.getInstance().addLog(
            Thread.currentThread().getName() + " extracted valuables worth: " + getTotalValue() + "; Goal: " + random);
      }

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
      ReadAddTreasureRoom room=treasureRoomDoor.acquireAdd();
      int total=valuables.size();
      int value=0;
    for (int i = 0; i < total; i++)
    {
      room.add(valuables.get(0));
      value+=valuables.get(0).getValue();
      valuables.remove(0);
    }
    Logger.getInstance().addLog(Thread.currentThread().getName() + " added all the valuables to the treasure room; total value: " + value );
    treasureRoomDoor.releaseAdd(room);
    room.add(null);
    }
  }
  public int getTotalValue()
  {
    int total=0;
    for(int i=0; i<valuables.size(); i++)
      total=total+valuables.get(i).getValue();
    return total;
  }
}
