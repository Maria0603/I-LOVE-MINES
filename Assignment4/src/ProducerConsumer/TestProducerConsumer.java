package ProducerConsumer;

import ReadersWritersProxy.Guardsman;
import ReadersWritersProxy.TreasureRoom;
import ReadersWritersProxy.TreasureRoomDoor;

public class TestProducerConsumer
{
  public static void main(String[] args)
  {
    Deposit deposit = new Deposit(50);
    TreasureRoom treasureRoom=new TreasureRoom();
    TreasureRoomDoor access=new Guardsman(treasureRoom);
    for (int i = 0; i < 3; i++)
    {
      Thread producer = new Thread(new Miner(deposit), "Miner " + i);
      producer.start();
    }

    for (int i = 0; i < 3; i++)
    {
      Thread consumer = new Thread(new ValuableTransporter(deposit, access), "Transporter " + i);
      consumer.start();
    }

  }
}
