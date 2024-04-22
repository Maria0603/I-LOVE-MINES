package ProducerConsumer;

import Mine.Valuable;

public class ValuableTransporter implements Runnable
{
  private Deposit deposit;
  private ArrayList<Valuable> valuables;
  public ValuableTransporter(Deposit deposit)
  {
    this.deposit=deposit;
    valuables=new ArrayList<>();
  }
  @Override public void run()
  {
    while(true)
    {
      int random = (int) Math.floor(Math.random() * (200 - 50 + 1) + 50);
      Logger.getInstance().addLog(Thread.currentThread().getName() + " must transport valuables worth at least: " + random);
      while (getTotalValue() < random)
      {
        valuables.add(deposit.extractValuable());
        Logger.getInstance().addLog(Thread.currentThread().getName() + " extracted valuables worth: " + getTotalValue() + "; Goal: " + random);
      }
      ///////////////// clear the list for now ////////////////////
      for (int i = 0; i < valuables.size(); i++)
        valuables.remove(0);
      Logger.getInstance().addLog(Thread.currentThread().getName() + " thrown the valuables away.");

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
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
