import java.util.Scanner;

public class ZerosAndOnes {

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
    zerosAndOnes();

  }
}
