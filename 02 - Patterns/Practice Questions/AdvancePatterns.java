import java.util.*;
// Hollow Rectangle, Inverted Pyrammid, Zeros and Ones

public class AdvancePatterns {

  public static void hollowRectangle() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows: ");
    int row = sc.nextInt();
    System.out.println("Enter number of columns ");
    int col = sc.nextInt();

    for (int i = 0; i < row; i++) {

      for (int j = 0; j < col; j++) {
        if (i == 0 || i == row - 1) {
          System.out.print("* ");
        } else {
          if (j == 0 || j == col - 1) {
            System.out.print("* ");
          } else {
            System.out.print("  ");
          }
        }
      }
      System.out.println();
    }
  }

  public static void invertedPyramid() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of rows: ");
    int row = sc.nextInt();

    for (int i = row - 1; i >= 0; i--) {

      for (int j = 0; j < row; j++) {
        if (i <= j) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }

  }

  public static void zerosAndOnes() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of rows: ");
    int row = sc.nextInt();

    for (int i = 0; i < row; i++) {

      for (int j = 0; j < row; j++) {
        if (i >= j) {
          if (j % 2 == 0) {
            System.out.print("1 ");
          } else {
            System.out.print("0 ");
          }
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }

  }

  public static void main(String args[]) {
    hollowRectangle();
    // invertedPyramid();
    // zerosAndOnes();

  }
}
