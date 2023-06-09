import java.util.Scanner;

public class SumOfDigits {
  public static void sumOfDigits(long n) {
    long num = n;
    long sum = 0, x = 0;

    while (num > 0) {
      x = num % 10;
      sum += x;
      num /= 10;
    }
    System.out.println("Sum of Digits of the NUmber " + n + ":");
    System.out.println(sum);

  }

  public static void main(String[] args) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    sumOfDigits(n);
  }

}
