import java.util.*;

public class InvertedStar {
  public static void main(String[] args) {
    // Inverted star , half pyramid, character
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number of Rows: ");
    int n = sc.nextInt();
    for (int row = 1; row <= n; row++) {
      for (int star = 1; star <= n - row + 1; star++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }
}