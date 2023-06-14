// Given an integer, K. Generate all binary strings of size k without consecutive 1’s.

public class BinaryStringsProblem {

  public static void printBinaryStrings(int n, String str, int lastPlace) {
    // base case
    if (n == 0) {
      System.out.println(str);
      return;
    }

    printBinaryStrings(n - 1, str + "0", 0);

    if (lastPlace == 0) {
      printBinaryStrings(n - 1, str + "1", 1);
    }

  }

  public static void main(String[] args) {
    int k = 3;
    String str = "";

    printBinaryStrings(k, str, 0);
  }
}
