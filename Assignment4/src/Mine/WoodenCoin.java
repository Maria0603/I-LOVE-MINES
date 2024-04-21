package Mine;

public class WoodenCoin implements Valuable {
  private String name;
  private int value;

  public WoodenCoin(String name, int value) {
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
