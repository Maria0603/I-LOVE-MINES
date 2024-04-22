package ReadersWritersProxy;

public interface TreasureRoomDoor {
    ReadList acquireRead();
    void releaseRead();
    ReadWriteList acquireWrite();
    void releaseWrite();
}
