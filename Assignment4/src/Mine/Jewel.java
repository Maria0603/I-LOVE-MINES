package Mine;

public class Jewel implements Valuable
{
  private String name;
  private int value;

  public Jewel(String name, int value) {
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