package ReadersWritersProxy;

public interface TreasureRoomDoor
{
  ReadTreasureRoom acquireRead();
  void releaseRead(ReadTreasureRoom room);
  WriteTreasureRoom acquireWrite();
  void releaseWrite(WriteTreasureRoom room);
}
