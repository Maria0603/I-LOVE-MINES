package Mine;

public class Diamond implements Valuable
{
  private String name;
  private int value;

  public Diamond(String name, int value)
  {
    this.name = name;
    this.value = value;
  }

  @Override public String getName()
  {
    return name;
  }

  @Override public int getValue()
  {
    return value;
  }
}
