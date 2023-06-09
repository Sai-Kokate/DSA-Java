import java.util.Scanner;

public class InvertedPyramid {
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

  public static void main(String args[]) {
    invertedPyramid();

  }
}
