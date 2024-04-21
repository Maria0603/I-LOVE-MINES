package Mine;

public class Ruby implements Valuable {
  private String name;
  private int value;

  public Ruby(String name,int value) {
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
