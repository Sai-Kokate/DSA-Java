import java.util.*;

public class Factorial {
  public static void main(String[] args) {
    // Factorial of any number enterned
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number to calculate its factorial:");
    int x = sc.nextInt();
    int fact = 1;
    for (int i = 1; i <= x; i++) {
      fact = fact * (i);
    }
    System.out.println("Factorial of " + x + " is " + fact);
  }
}