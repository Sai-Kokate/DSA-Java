public class SumOfnNumbers {
  // find sum of n natural numbers
  public static int printSum(int n) {

    // base case
    if (n == 1) {
      return 1;
    }

    return (n + printSum(n - 1));

  }

  public static void main(String[] args) {
    int n = 25;
    System.out.println(printSum(n));
  }
}
