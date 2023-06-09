import java.util.*;

public class FunctionsAndMethods {
  public static boolean isPrime(int p) {
    if (p == 2) {
      return true;
    }

    for (int i = 2; i < Math.sqrt(p); i++) {
      if (p % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void primeRange(int n) {
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        System.out.print(i + " ");
      }
    }

    System.out.println("These are all the prime numbers betwwen 1 to " + n);
  }

  public static void sumOfDigits(int n) {
    int x = 0, num = n;
    int sum = 0;

    while (num > 0) {
      x = num % 10;
      sum += x;
      num /= 10;
    }

    System.out.println(sum);

  }

  public static void palindrome(int n) {
    int reverse = 0;
    int x = 0, p = 0;
    int num = n;

    while (num > 0) {
      x = num % 10;
      // System.out.println("x " + x);
      reverse = reverse * 10 + x;
      // System.out.println(reverse);
      num = num / 10;
      // System.out.println("num " + num);

      // System.out.println("p " + p);
    }
    System.out.println("Reverse of the number: " + reverse);

    if (reverse == n) {
      System.out.println("The number " + n + " is a palindrome!");
    } else {
      System.out.println("The number " + n + " is NOT a palindrome!");
    }
  }

  public static void main(String args[]) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // sumOfDigits(n);
    // palindrome(n);

  }
}
