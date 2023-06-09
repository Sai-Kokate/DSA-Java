import java.util.*;

public class IsPrime {

  public static boolean isPrime(int p) {
    if (p == 2) {
      return true;
    }

    for (int i = 2; i <= (int) Math.sqrt(p); i++) {
      if (p % i == 0) {
        return false;

      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean ans = isPrime(n);
    if (ans) {
      System.out.println("Entered Number " + n + " is a Prime Number");
    } else {
      System.out.println("Entered Number " + n + " is NOT a Prime Number");
    }
  }
}