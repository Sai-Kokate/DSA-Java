import java.util.Scanner;

public class ButterflyPattern {
  public static void butterflyPattern(int n) {
    // upper part
    for (int i = 1; i <= n; i++) {
      // i starts
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 2(n-i) spaces
      for (int j = 1; j <= (n - i); j++) {
        System.out.print("  ");
      }

      // i starts
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    // lower part
    for (int i = n; i >= 1; i--) {
      // i starts
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 2(n-i) spaces
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }

      // i starts
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = sc.nextInt();
    butterflyPattern(n);

  }
}