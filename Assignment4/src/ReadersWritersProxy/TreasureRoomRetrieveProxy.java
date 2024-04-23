package ReadersWritersProxy;

import ProducerConsumer.Valuable;

public class TreasureRoomRetrieveProxy implements ReadAddRetrieveTreasureRoom
{
  private TreasureRoom treasureRoom;

  public TreasureRoomRetrieveProxy(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public Valuable read()
  {
      if(treasureRoom!=null)
          return treasureRoom.read();
      else throw new IllegalStateException("Access denied.");
  }

  @Override public void add(Valuable v)
  {
      if(treasureRoom!=null)
          treasureRoom.add(v);
      else throw new IllegalStateException("Access denied.");
  }

  @Override public Valuable retrieve(Valuable v)
  {
      if(treasureRoom!=null)
          return treasureRoom.retrieve(v);
      else throw new IllegalStateException("Access denied.");
  }

  public void terminate()
  {
    treasureRoom = null;
  }
}
