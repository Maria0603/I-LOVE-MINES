package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomReadProxy implements ReadTreasureRoom
{

  private TreasureRoom treasureRoom;

  public TreasureRoomReadProxy(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public Valuable read()
  {
    if (treasureRoom!=null)
        return treasureRoom.read();
    throw new IllegalStateException("Access denied.");
  }
  public void terminate()
  {
      treasureRoom=null;
  }
}
