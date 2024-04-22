package Mine;

public class GoldenNugget implements Valuable

{ private String name;
  private int value;

  public GoldenNugget(String name, int value) {
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
