// Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.

public class Sudoku {
  public static void printSudoku(int sudoku[][]) {
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        System.out.print(sudoku[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean canPlace(int sudoku[][], int row, int col, int num) {

    // check row
    for (int i = 0; i < 9; i++) {
      if (sudoku[row][i] == num) {
        return false;
      }
    }

    // check column
    for (int i = 0; i < 9; i++) {
      if (sudoku[i][col] == num) {
        return false;
      }
    }

    // check grid
    int startRow = row / 3 * 3;
    int startCol = col / 3 * 3;

    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (sudoku[i][j] == num) {
          return false;
        }
      }
    }

    return true;

  }

  public static boolean sudokuSolver(int sudoku[][], int row, int col) {
    // base case
    if (row == 9) {
      printSudoku(sudoku);
      return true;
    }

    int nextRow = row, nextCol = col + 1;
    if (col + 1 == 9) {
      nextRow = row + 1;
      nextCol = 0;
    }

    if (sudoku[row][col] != 0) {
      return sudokuSolver(sudoku, nextRow, nextCol);
    }

    if (sudoku[row][col] == 0) {
      for (int i = 1; i <= 9; i++) {
        if (canPlace(sudoku, row, col, i)) {
          sudoku[row][col] = i;
          if (sudokuSolver(sudoku, nextRow, nextCol)) {
            return true;
          }
          sudoku[row][col] = 0;
        }

      }
    }

    return false;
  }

  public static void main(String[] args) {
    int sudoku[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

    sudokuSolver(sudoku, 0, 0);

  }

}
