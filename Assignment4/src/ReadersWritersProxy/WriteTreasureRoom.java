package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface WriteTreasureRoom extends ReadTreasureRoom
{
  Valuable retrieve(Valuable v);
  void add(Valuable v);
}
