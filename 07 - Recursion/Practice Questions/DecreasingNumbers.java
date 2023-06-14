
public class DecreasingNumbers {
  public static void printDecreasingNumbers(int n) {

    // bas case
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }

    System.out.print(n + " ");
    printDecreasingNumbers(n - 1);

  }

  public static void main(String[] args) {
    int num = 10;
    printDecreasingNumbers(num);
  }
}