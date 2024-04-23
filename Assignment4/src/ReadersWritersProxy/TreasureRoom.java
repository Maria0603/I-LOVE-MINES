package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.ListADT;
import ProducerConsumer.Valuable;

public class TreasureRoom implements ReadAddRetrieveTreasureRoom
{
    private ListADT<Valuable> list;
    public TreasureRoom(){
        list = new ArrayList<>();
    }
    //  TODO: UPDATE THE FUNCTIONALITY
    @Override
    public Valuable read() {
        return Valuable.getInstance("diamond");
    }

    @Override
    public void add(Valuable v) {
        list.add(v);
    }

    @Override
    public Valuable retrieve(Valuable v) {
        return list.remove(v);
    }


    //  Stolen from exercise
    //  use in methods above for time simulation
    private void simulateThatItTakesTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {/* empty*/ }
    }
}
