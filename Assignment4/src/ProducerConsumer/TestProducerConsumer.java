package ProducerConsumer;

public class TestProducerConsumer
{
  public static void main(String[] args)
  {
    Deposit deposit = new Deposit(50);

    for (int i = 0; i < 3; i++)
    {
      Thread producer = new Thread(new Miner(deposit), "Miner " + i);
      producer.start();
    }

    for (int i = 0; i < 3; i++)
    {
      Thread consumer = new Thread(new ValuableTransporter(deposit), "Transporter " + i);
      consumer.start();
    }
  }
}
