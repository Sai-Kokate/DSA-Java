import java.util.Scanner;

public class Palindrome {
  public static void palindrome(int n) {
    int reverse = 0;
    int x = 0;
    int num = n;

    while (num > 0) {
      x = num % 10;
      reverse = reverse * 10 + x;
      num = num / 10;
    }
    System.out.println("Reverse of the number: " + reverse);

    if (reverse == n) {
      System.out.println("The number " + n + " is a palindrome!");
    } else {
      System.out.println("The number " + n + " is NOT a palindrome!");
    }
  }

  public static void main(String[] args) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    palindrome(n);
  }
}
