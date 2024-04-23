package ReadersWritersProxy;

public interface TreasureRoomDoor
{
  ReadTreasureRoom acquireRead();
  void releaseRead(ReadTreasureRoom room);
  ReadAddTreasureRoom acquireAdd();
  void releaseAdd(ReadAddTreasureRoom room);
  ReadAddRetrieveTreasureRoom acquireRetrieve();
  void releaseRetrieve(ReadAddRetrieveTreasureRoom room);
}
