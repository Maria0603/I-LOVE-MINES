package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.ListADT;
import ProducerConsumer.Valuable;

import java.io.IOException;

public class TreasureRoom implements WriteTreasureRoom
{
    private ListADT<Valuable> list;
    public TreasureRoom(){
        list = new ArrayList<>();
    }
    //TODO: UPDATE THE FUNCTIONALITY
    @Override
    public Valuable read(int valuableIndex) {

        try {
            list.get(valuableIndex);
            return list.get(valuableIndex);

        }catch (IllegalStateException e){
            return null;
        }

    }

    @Override
    public synchronized void add(Valuable v) {
        list.add(v);
    }

    @Override
    public synchronized Valuable retrieve(Valuable v) {
        return list.remove(v);
    }

    @Override public Valuable popValuableFromRoom() {
        Valuable popedValuable;
        try {
            popedValuable = list.remove(0);
            return popedValuable;
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public int getSize(){
        return list.size();
    }

    private void simulateThatItTakesTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {/* empty*/ }
    }
}
