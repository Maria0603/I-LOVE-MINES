package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface WriteTreasureRoom extends ReadTreasureRoom
{
  Valuable retrieve();
  void add(Valuable v);
}
