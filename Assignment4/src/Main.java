import ProducerConsumer.Deposit;
import ProducerConsumer.Miner;
import ProducerConsumer.ValuableTransporter;
import ReadersWritersProxy.*;

public class Main
{
  public static void main(String[] args)
  {
    Deposit deposit = new Deposit(50);
    TreasureRoom treasureRoom = new TreasureRoom();
    TreasureRoomDoor access = new Guardsman(treasureRoom);
    for (int i = 0; i < 2; i++)
    {
      Thread producer = new Thread(new Miner(deposit), "Miner " + i);
      producer.start();
    }

    for (int i = 0; i < 2; i++)
    {
      Thread consumer = new Thread(new ValuableTransporter(deposit, access),
          "Transporter " + i);
      consumer.start();
    }

    for (int i = 0; i < 2; i++)
    {
      Thread reader = new Thread(new Accountant(access), "Accountant " + i);
      reader.start();
    }

    Thread king = new Thread(new King(access), "King");
    king.start();
  }
}