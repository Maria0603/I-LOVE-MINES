package Mine;

public class GoldenNugget implements Valuable

{ private String name;
  private int value;

  public GoldenNugget(String name, int value) {
    this.name = name;
    this.value = value;
  }

  @Override public String getName() {
    return name;
  }

  @Override public int getValue() {
    return value;
  }
}
