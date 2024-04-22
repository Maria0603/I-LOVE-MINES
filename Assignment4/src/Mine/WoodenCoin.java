package Mine;

public class WoodenCoin implements Valuable
{
  private String name;
  private int value;

  public WoodenCoin(String name, int value) {
    this.name = name;
    this.value = value;
  }

   public String getName() {
    return name;
  }

   public int getValue() {
    return value;
  }
   public String toString()
  {
    return name + ": " + value;
  }
}
