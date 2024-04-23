package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface ReadAddTreasureRoom extends ReadTreasureRoom
{
    void add(Valuable v);
}
