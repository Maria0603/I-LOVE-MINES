package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomWriteProxy implements ReadWriteList{
    private TreasureRoom treasureRoom;
    private Guardsman access;
    public TreasureRoomWriteProxy(TreasureRoom treasureRoom, Guardsman access){
        this.treasureRoom = treasureRoom;
        this.access = access;
    }
    @Override
    public Valuable read() {
        if(access.hasWriteAccess(Thread.currentThread()))
            throw new IllegalStateException("Thread is not on the list");

        return treasureRoom.read();
    }

    @Override
    public void add(Valuable v) {
        if(access.hasWriteAccess(Thread.currentThread()))
            throw new IllegalStateException("Thread is not on the list");

        treasureRoom.add(v);
    }

    @Override
    public Valuable retrieve(Valuable v) {
        if(access.hasWriteAccess(Thread.currentThread()))
            throw new IllegalStateException("Thread is not on the list");

        return treasureRoom.retrieve(v);
    }
}
