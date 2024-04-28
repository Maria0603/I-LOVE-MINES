package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.Logger;
import ProducerConsumer.Valuable;

public class King implements Runnable
{

  private ArrayList<Valuable> kingsPocket;
  private TreasureRoomDoor treasureRoomDoor;

  public King(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
    kingsPocket = new ArrayList<>();
  }

  @Override public void run()
  {
    while (true)
    {
      int neededForParty = (int) Math.floor(Math.random() * 100 + 50);
      Logger.getInstance().addLog(Thread.currentThread().getName()
          + " needs at least $" + neededForParty + " to throw a party.");

      WriteTreasureRoom room = treasureRoomDoor.acquireWrite();

      int collectedMoney = 0;
      int treasureRoomSize = room.getSize();

      for (int i = 0; i < treasureRoomSize && collectedMoney<neededForParty; i++)
      {

        Valuable gemFromTreasureRoom = room.retrieve();

        kingsPocket.add(gemFromTreasureRoom);

        collectedMoney += gemFromTreasureRoom.getValue();
      }

      takesTime(1);

      int pocketSize = kingsPocket.size();

      if (collectedMoney >= neededForParty)
      {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " has enough money to throw a party; Collected: $" + collectedMoney
            + "; Needed: $" + neededForParty);

        for (int i = 0; i < pocketSize; i++)
        {
          kingsPocket.remove(0);
        }

        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " has spent all the money to throw a party: $" + collectedMoney);

      }
      else
      {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " does not have enough money to throw a party: $" + neededForParty + "; Only collected: $" + collectedMoney);

        for (int i = 0; i < pocketSize; i++)
        {
          Valuable extractedGem = kingsPocket.remove(0);
          room.add(extractedGem);
        }

        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " returned money to the treasure room: $" + collectedMoney);
      }
      takesTime(1);
      treasureRoomDoor.releaseWrite(room);
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
