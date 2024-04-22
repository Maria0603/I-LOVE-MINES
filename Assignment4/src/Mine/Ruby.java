package Mine;

public class Ruby implements Valuable
{
  private String name;
  private int value;

  public Ruby(String name, int value)
  {
    this.name = name;
    this.value = value;
  }

  public String getName()
  {
    return name;
  }

  public int getValue()
  {
    return value;
  }

  public String toString()
  {
    return name + ": " + value;
  }

}
