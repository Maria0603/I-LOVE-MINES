package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.Deposit;
import ProducerConsumer.Logger;
import ProducerConsumer.Valuable;

public class Accountant implements Runnable {
  private TreasureRoomDoor treasureRoomDoor;

  public Accountant(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run() {
    while (true) {
     /* Logger.getInstance().addLog(Thread.currentThread().getName()
          + " is acquiring to calculate money stored in Treasure Room");*/

      ReadTreasureRoom room = treasureRoomDoor.acquireRead();

      /*Logger.getInstance().addLog(Thread.currentThread().getName()
          + " starts to calculate money stored in Treasure Room");
*/
      int moneyInTotal = 0;
      int index = 0;

      while (true){
        Valuable gemFromTreasureRoom = room.read(index);

        if(gemFromTreasureRoom == null){
          break;
      } else {
          moneyInTotal += gemFromTreasureRoom.getValue();
          index++;
          takeTimeToCalculate(1);

        }
      }

      Logger.getInstance().addLog(Thread.currentThread().getName() + " has calculated all the money from the treasure room: " + moneyInTotal  + "$");
      treasureRoomDoor.releaseRead(room);

      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        //
      }

    }
  }

  private void takeTimeToCalculate(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {/* empty*/ }
  }

}
