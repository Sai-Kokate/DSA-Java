import java.util.*;

public class HalfPyramid {
  public static void main(String[] args) {
    // Half pyramid
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number of Rows: ");
    int n = sc.nextInt();
    for (int row = 1; row <= n; row++) {
      for (int star = 1; star <= row; star++) {
        System.out.print(star);
      }
      System.out.println();
    }

    // Charachter pattern
    char ch = 'A';
    for (int row = 1; row <= n; row++) {
      for (int star = 1; star <= row; star++) {
        System.out.print(ch);
        ch++;
      }
      System.out.println();
    }
  }
}
