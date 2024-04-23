package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface ReadAddRetrieveTreasureRoom extends ReadAddTreasureRoom
{
  Valuable retrieve(Valuable v);
}
