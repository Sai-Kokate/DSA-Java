import java.util.*;

public class PrimesInRange {

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

  public static void primeRange(int n) {
    if (n == 1) {
      System.out.println("1");
      return;
    }
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        System.out.print(i + " ");
      }
    }

    System.out.println("\n\nThese are all the prime numbers betwwen 1 to " + n);
  }

  public static void main(String[] args) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    primeRange(n);
  }

}