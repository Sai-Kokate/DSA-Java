// The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. 

public class NQueens {
  static int count = 0;

  public static void printBoard(char ch[][]) {
    System.out.println("------ Chess Board ------");

    for (int i = 0; i < ch.length; i++) {
      for (int j = 0; j < ch.length; j++) {
        System.out.print(ch[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean isSafe(char board[][], int row, int col) {
    int n = board.length;

    // column check
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // left up diagonal check
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // right up diagonal check
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // if no check is true then, queen can be placed
    return true;
  }

  public static void possibleSolutions(char board[][], int row) {
    // base case
    if (row == board.length) {
      count++;
      printBoard(board);
      return;
    }

    // column loop for current row
    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        possibleSolutions(board, row + 1); // recursion step , after placement , moving on to next row
        board[row][j] = 'x'; // backtracking step
      }
    }

  }

  public static void main(String[] args) {
    int n = 4;
    char board[][] = new char[n][n];

    // initialization
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }

    // function call
    possibleSolutions(board, 0);
    System.out.println("Total possible solutions = " + count);

  }

}
