package DepositStuff;

import Mine.Valuable;

public class Deposit {
  private ListADT list;
  private Valuable valuable;
  private int capacity;

  public Deposit(int capacity) {
    list = (ListADT) new ArrayList();
    this.capacity = capacity;
  }

  public synchronized void putValuable(Valuable valuable) {
    while (list.size() >= capacity) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    list.add(valuable);
    notifyAll();
  }

  public synchronized Valuable getValuable() {
    while (list.isEmpty()) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Valuable valuable = (Valuable) list.remove(list.size() - 1);
    return valuable;
  }
}
