package ProducerConsumer;

import Mine.Valuable;
import Mine.ValuableFactory;

public class Miner implements Runnable
{
  private Deposit deposit;
  public Miner(Deposit deposit)
  {
    this.deposit=deposit;
  }
  @Override public void run()
  {
    while(true)
    {
      Valuable valuable;
      double random=Math.random();
      if(random<0.2)
        valuable = ValuableFactory.getValuable("diamond");
      else if(random<0.4)
        valuable = ValuableFactory.getValuable("goldenNugget");
      else if(random<0.6)
        valuable = ValuableFactory.getValuable("jewel");
      else if(random<0.8)
        valuable = ValuableFactory.getValuable("ruby");
      else valuable = ValuableFactory.getValuable("woodenCoin");

      Logger.getInstance().addLog(Thread.currentThread().getName() + " found a valuable: "+ valuable);
      deposit.depositValuable(valuable);
      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e)
      {
        //
      }
    }
  }
}
