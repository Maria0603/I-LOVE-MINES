package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomAddProxy implements ReadAddTreasureRoom
{
  private TreasureRoom treasureRoom;

  public TreasureRoomAddProxy(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public Valuable read()
  {
    if (treasureRoom != null)
      return treasureRoom.read();
    else
      throw new IllegalStateException("Access denied.");
  }

  @Override public void add(Valuable v)
  {
    if (treasureRoom != null)
      treasureRoom.add(v);
    else
      throw new IllegalStateException("Access denied.");
  }

  public void terminate()
  {
    treasureRoom = null;
  }
}