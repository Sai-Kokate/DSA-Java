public class RotateMatrix {
  public static void printMatrix(int num[][]) {
    for (int i = 0; i < num.length; i++) {
      for (int j = 0; j < num[0].length; j++) {
        System.out.print(num[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void swap(int[][] matrix, int i, int j) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[j][i];
    matrix[j][i] = temp;
  }

  public static void rotate(int[][] matrix) {
    int n = matrix.length;

    // Transpose of a matrix
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        swap(matrix, i, j);
      }
    }

    // reverse each row
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    printMatrix(matrix);
    rotate(matrix);
    System.out.println();

    printMatrix(matrix);

  }
}
