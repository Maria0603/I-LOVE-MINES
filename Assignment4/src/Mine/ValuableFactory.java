package Mine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ValuableFactory
{
  private static Map<String, Valuable> valuableMap=new HashMap<>();
  private static Lock lock=new ReentrantLock();
  private ValuableFactory()
  {

  }

  public static Valuable getValuable(String name)
  {
    Valuable valuable = valuableMap.get(name.toLowerCase());
    if (valuable == null)
    {
      synchronized (lock)
      {
        valuable = valuableMap.get(name);

        if (valuable == null) {
          switch (name) {
            case "diamond":
              valuable = new Diamond("diamond", 80);
              break;
            case "goldenNugget":
              valuable = new GoldenNugget("goldenNugget", 45);
              break;
            case "jewel":
              valuable = new Jewel("jewel", 25);
              break;
            case "ruby":
              valuable = new Ruby("ruby", 20);
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
