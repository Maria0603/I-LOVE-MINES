package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface WriteTreasureRoom extends ReadTreasureRoom
{
  Valuable retrieve(Valuable v);
  Valuable popValuableFromRoom();
  void add(Valuable v);
  int getSize();
}
