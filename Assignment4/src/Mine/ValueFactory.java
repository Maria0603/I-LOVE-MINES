package Mine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ValueFactory
{
  private static Map<String, Valuable> valuableMap = new HashMap<>();
  private static Lock lock = new ReentrantLock();

  private static Valuable getValuable(String name)
  {
    Valuable valuable = valuableMap.get(name.toLowerCase());

    if (valuable == null)
    {
      synchronized (lock)
      {
        valuable = valuableMap.get(name);

        if (valuable == null) {
          switch (name.toLowerCase().trim()) {
            case "diamond":
              valuable = new Diamond("diamond", 100);
              break;
            case "goldenNugget":
              valuable = new GoldenNugget("goldNugget", 75);
              break;
            case "jewel":
              valuable = new Jewel("jewel", 50);
              break;
            case "ruby":
              valuable = new Ruby("ruby", 25);
              break;
            case "woodenCoin":
              valuable = new WoodenCoin("woodenCoin", 5);
              break;
          }
        }
      }
      valuableMap.put(name.toLowerCase(),valuable);
    }
    return valuable;
  }
}
