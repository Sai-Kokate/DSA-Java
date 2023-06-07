import java.util.*;

public class ReverseNumber {
  public static int reverse(int x) {
    int reverse = 0;
    while (x != 0) {
      int rem = x % 10;
      if (reverse < (Integer.MIN_VALUE / 10) || reverse > (Integer.MAX_VALUE / 10)) {
        return 0;
      }
      reverse = (reverse * 10) + rem;
      x = x / 10;
    }

    return reverse;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number");
    int n = sc.nextInt();
    System.out.println("Reverse of " + n + " is :");
    System.out.print(reverse(n));

  }
}