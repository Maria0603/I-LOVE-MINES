package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.ListADT;
import ProducerConsumer.Valuable;

import java.io.IOException;

public class TreasureRoom implements WriteTreasureRoom
{
  private ListADT<Valuable> list;

  public TreasureRoom()
  {
    list = new ArrayList<>();
  }

  @Override public synchronized Valuable read(int valuableIndex)
  {
      try
      {
          return list.get(valuableIndex);
      }
      catch(IllegalStateException e)
      {
          return null;
      }
  }

  @Override public synchronized void add(Valuable v)
  {
    list.add(v);
  }

  @Override public synchronized Valuable retrieve()
  {
      Valuable popedValuable;
      try
      {
          popedValuable = list.remove(0);
          return popedValuable;
      }
      catch (IndexOutOfBoundsException e)
      {
          return null;
      }
  }


  public synchronized int getSize()
  {
    return list.size();
  }

  private void simulateThatItTakesTime(int seconds)
  {
    try
    {
      Thread.sleep(seconds * 1000);
    }
    catch (InterruptedException e)
    {/* empty*/ }
  }
}
