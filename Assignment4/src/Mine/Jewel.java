package Mine;

public class Jewel implements Valuable
{
  private String name;
  private int value;

  public Jewel(String name, int value) {
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