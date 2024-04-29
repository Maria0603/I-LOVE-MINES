package ProducerConsumer;

public class Deposit
{
  private ListADT<Valuable> list;

  private int capacity;

  public Deposit(int capacity)
  {
    list = new ArrayList<>();
    this.capacity = capacity;
  }

  public synchronized void depositValuable(Valuable valuable)
  {
    while (list.size() >= capacity)
    {
      try
      {
        Logger.getInstance().addLog(
            Thread.currentThread().getName() + " is waiting to deposit a "
                + valuable + "; The deposit contains " + list.size()
                + " valuables: " + list.toString());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    list.add(valuable);
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " deposited a " + valuable
            + "; The deposit contains " + list.size() + " valuables: "
            + list.toString());
    notifyAll();
  }

  public synchronized Valuable extractValuable()
  {
    while (list.isEmpty())
    {
      try
      {
        Logger.getInstance().addLog(Thread.currentThread().getName()
            + " is waiting to extract a valuable; The deposit contains "
            + list.size() + " valuables: " + list.toString());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    Valuable valuable = list.remove(list.size() - 1);
    Logger.getInstance().addLog(
        Thread.currentThread().getName() + " extracted a " + valuable
            + "; The deposit contains " + list.size() + " valuables: "
            + list.toString());
    return valuable;
  }
}
