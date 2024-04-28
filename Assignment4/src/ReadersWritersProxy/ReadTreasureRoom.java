package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface ReadTreasureRoom
{
    Valuable read(int valuableIndex);
    int getSize();
}
