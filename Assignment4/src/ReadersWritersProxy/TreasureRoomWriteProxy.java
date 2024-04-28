package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomWriteProxy implements WriteTreasureRoom
{
  private TreasureRoom treasureRoom;

  public TreasureRoomWriteProxy(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public Valuable read(int valuableIndex)
  {
      if(treasureRoom!=null)
          return treasureRoom.read(valuableIndex);
      else throw new IllegalStateException("Access denied.");
  }

  @Override public void add(Valuable v)
  {
      if(treasureRoom!=null)
          treasureRoom.add(v);
      else throw new IllegalStateException("Access denied.");
  }

  @Override public int getSize() {
    return 0;
  }

  @Override public Valuable retrieve(Valuable v)
  {
      if(treasureRoom!=null)
          return treasureRoom.retrieve(v);
      else throw new IllegalStateException("Access denied.");
  }

  @Override public Valuable popValuableFromRoom() {
    if(treasureRoom!=null)
      return treasureRoom.popValuableFromRoom();
    else throw new IllegalStateException("Access denied.");
  }

  public void terminate()
  {
    treasureRoom = null;
  }
}
