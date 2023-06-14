
public class IncreasingNumbers {

  public static void printIncreasingNumbers(int n) {

    // bas case
    if (n == 1) {
      System.out.print(n + " ");
      return;
    }
    printIncreasingNumbers(n - 1);

    System.out.print(n + " ");

  }

  public static void main(String[] args) {
    int num = 10;
    printIncreasingNumbers(num);
  }
}
