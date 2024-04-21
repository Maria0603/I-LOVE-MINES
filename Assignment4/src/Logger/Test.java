package Logger;

public class Test {
  public static void main(String[] args) {
    Log log1 = Log.getInstance();
    Log log2 = Log.getInstance();

    System.out.println(log1);
    System.out.println(log2);
  }
}
