public class FibonacciNumber {

  public static int fabNumber(int index) {
    // base case
    if (index == 1) {
      return 0;
    }
    if (index == 2) {
      return 1;
    }

    return fabNumber(index - 1) + fabNumber(index - 2);

  }

  public static void main(String[] args) {
    int index = 25;

    System.out.println(fabNumber(index));

  }

}
