package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomReadProxy implements ReadList{

    private TreasureRoom treasureRoom;
    private Guardsman access;
    public TreasureRoomReadProxy(TreasureRoom treasureRoom, Guardsman access){
        this.treasureRoom = treasureRoom;
        this.access = access;
    }
    @Override
    public Valuable read() {
        if(access.hasReadAccess(Thread.currentThread()))
            throw new IllegalStateException("Thread is not on the list");

        return treasureRoom.read();
    }
}
