package ProducerConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Valuable
{
  private static Map<String, Valuable> valuableMap = new HashMap<>();
  // [ {"diamond", new Valuable("diamond", 150) } ]
  // map.get("diamond") -> Valuable("diamond", 150)
  private static Lock lock = new ReentrantLock();
  private String name;
  private int value;

  private Valuable(String name, int value)
  {
    this.name = name;
    this.value = value;
  }

  public static Valuable getInstance(String name)
  {
    Valuable instance = valuableMap.get(name);
    int random;
    if (instance == null)
    {
      synchronized (valuableMap)
      {
        if (instance == null)
        {
          switch (name)
          {
            case "diamond":
              random = (int) Math.floor(Math.random() * (90 - 70 + 1) + 70);
              instance = new Valuable("diamond", random);
              break;
            case "golden nugget":
              random = (int) Math.floor(Math.random() * (55 - 35 + 1) + 35);
              instance = new Valuable("golden nugget", random);
              break;
            case "jewel":
              random = (int) Math.floor(Math.random() * (35 - 15 + 1) + 15);
              instance = new Valuable("jewel", random);
              break;
            case "ruby":
              random = (int) Math.floor(Math.random() * (30 - 10 + 1) + 10);
              instance = new Valuable("ruby", random);
              break;
            case "wooden coin":
              instance = new Valuable("wooden coin", 1);
              break;
          }
        }
      }
      valuableMap.put(name, instance);
    }
    return instance;
  }

  public String getName()
  {
    return name;
  }

  public int getValue()
  {
    return value;
  }

  public String toString()
  {
    return name + " ($" + value + ")";
  }

}
