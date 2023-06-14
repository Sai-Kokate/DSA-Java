public class FindPower {

  public static int findPower(int x, int n) {
    // base case
    if (n == 0) {
      return 1;
    }

    int num = findPower(x, n / 2);
    int numSq = num * num;
    if (n % 2 != 0) {
      numSq = x * numSq;
    }

    return numSq;
  }

  public static void main(String[] args) {
    int x = 3;
    int n = 6;

    System.out.println(findPower(x, n));
  }
}
