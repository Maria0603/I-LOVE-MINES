package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.Logger;
import ProducerConsumer.Valuable;

public class King implements Runnable {

  private ArrayList<Valuable> kingsPocket;
  private TreasureRoomDoor treasureRoomDoor;

  public King(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
    kingsPocket = new ArrayList<>();
  }

  @Override public void run() {
    while (true) {
      int neededForParty = (int) Math.floor(Math.random() * (100) + 50);
      Logger.getInstance().addLog(
          Thread.currentThread().getName() + " needs at least to throw a party: "
              + neededForParty);

      WriteTreasureRoom room = treasureRoomDoor.acquireWrite();
      //Logger.getInstance().addLog(Thread.currentThread().getName() + "starts taking money for a party");

      int collectedMoney = 0;
      int treasureRoomSize = room.getSize();

      Logger.getInstance().addLog(
          Thread.currentThread().getName() + " is filling his pocket ");
      for (int i = 0; i < treasureRoomSize; i++) {

        Valuable gemFromTreasureRoom = room.read(0);

        kingsPocket.add(gemFromTreasureRoom);
        room.retrieve(gemFromTreasureRoom);

        collectedMoney += gemFromTreasureRoom.getValue();
      }

      takeTimeToCalculate(1);

      int pocketSize = kingsPocket.size();

      if (collectedMoney >= neededForParty) {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " has enough money to throw a party: " + collectedMoney + " from needed" + neededForParty);

        for (int i = 0; i < pocketSize; i++) {
          Valuable extractedGem = kingsPocket.remove(0);
        }

        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " has spent all the money to throw a party: ");

      }else {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " does not have enough money to throw a party: ");

        for (int i = 0; i < pocketSize; i++) {
          Valuable extractedGem = kingsPocket.remove(0);
          room.add(extractedGem);
        }

        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " returned money to the treasure room: " + collectedMoney);
      }
    }
  }

  private void takeTimeToCalculate(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    }
    catch (InterruptedException e) {/* empty*/ }
  }
}
