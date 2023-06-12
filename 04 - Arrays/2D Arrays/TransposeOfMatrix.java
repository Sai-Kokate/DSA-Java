public class TransposeOfMatrix {
  public static void printMatrix(int num[][]) {
    for (int i = 0; i < num.length; i++) {
      for (int j = 0; j < num[0].length; j++) {
        System.out.print(num[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void matrixTranspose(int num[][]) {
    int n = num.length;
    int m = num[0].length;
    int transpose[][] = new int[m][n];

    for (int i = 0; i < num.length; i++) {
      for (int j = 0; j < num[0].length; j++) {
        transpose[j][i] = num[i][j];
      }
    }
    System.out.println("Transpose of the Matrix is: ");
    printMatrix(transpose);

  }

  public static void main(String[] args) {
    int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    matrixTranspose(matrix);
  }
}
