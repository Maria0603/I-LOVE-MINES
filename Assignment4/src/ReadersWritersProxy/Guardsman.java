package ReadersWritersProxy;

import ProducerConsumer.ArrayList;
import ProducerConsumer.ListADT;
import ProducerConsumer.Logger;

public class Guardsman implements TreasureRoomDoor{
    private int readers;
    private int writers;
    private int waitingWriters;
    private TreasureRoomReadProxy readProxy;
    private TreasureRoomWriteProxy writeProxy;
    private ListADT<Thread> allowedReadAccess;
    private ListADT<Thread> allowedWriteAccess;
    public Guardsman(TreasureRoom treasureRoom){
        readers = 0;
        writers = 0;
        waitingWriters = 0;

        allowedReadAccess = new ArrayList<>();
        allowedWriteAccess = new ArrayList<>();
        readProxy = new TreasureRoomReadProxy(treasureRoom, this);
        writeProxy = new TreasureRoomWriteProxy(treasureRoom, this);
    }
    @Override
    public ReadList acquireRead() {
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is acquiring read; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
        while (writers > 0 || waitingWriters > 0){
            try {
                Logger.getInstance().addLog(Thread.currentThread().getName() + " waiting to read; " +
                        "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
                wait();
            } catch (InterruptedException e) {
                //  ...
            }
        }

        if(!allowedReadAccess.contains(Thread.currentThread()))
            allowedReadAccess.add(Thread.currentThread());

        readers++;
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is READING; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
        return readProxy;
    }

    @Override
    public void releaseRead() {
        readers--;
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is releasing read; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
        allowedReadAccess.remove(Thread.currentThread());
        if(readers == 0)
            notify();
    }

    @Override
    public ReadWriteList acquireWrite() {
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is acquiring write; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
        waitingWriters++;
        while (readers > 0 || writers > 0){
            Logger.getInstance().addLog(Thread.currentThread().getName() + " waiting to write; " +
                    "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
            try {
                wait();
            } catch (InterruptedException e) {
                //  ...
            }
        }
        waitingWriters--;

        if(!allowedWriteAccess.contains(Thread.currentThread()))
            allowedWriteAccess.add(Thread.currentThread());

        writers++;
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is WRITING; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);
        return writeProxy;
    }

    @Override
    public void releaseWrite() {
        writers--;
        Logger.getInstance().addLog(Thread.currentThread().getName() + " is releasing write; " +
                "readers: " + readers + ", writers: " + writers + ", waiting writers: " + waitingWriters);

        allowedWriteAccess.remove(Thread.currentThread());

        notifyAll();
    }
    public boolean hasReadAccess(Thread t){
        return allowedReadAccess.contains(t);
    }
    public boolean hasWriteAccess(Thread t){
        return allowedWriteAccess.contains(t);
    }
}
