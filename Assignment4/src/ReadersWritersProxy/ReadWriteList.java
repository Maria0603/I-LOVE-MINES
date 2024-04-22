package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public interface ReadWriteList extends ReadList {
    void add(Valuable v);
    Valuable retrieve(Valuable v);
}
