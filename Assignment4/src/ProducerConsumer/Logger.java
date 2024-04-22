package ProducerConsumer;

public class Logger
{
  private static Logger instance;
  private static final Object lock = new Object();

  private Logger()
  {
  }

  public static Logger getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {

          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void addLog(String text)
  {
    System.out.println(text);
  }

}
