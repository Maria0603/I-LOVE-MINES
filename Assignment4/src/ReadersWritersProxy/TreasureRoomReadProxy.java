package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomReadProxy implements ReadTreasureRoom
{

  private TreasureRoom treasureRoom;

  public TreasureRoomReadProxy(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public Valuable read(int valuableIndex)
  {
    if (treasureRoom!=null)
        return treasureRoom.read(valuableIndex);
    throw new IllegalStateException("Access denied.");
  }
  public void terminate()
  {
      treasureRoom=null;
  }
}
