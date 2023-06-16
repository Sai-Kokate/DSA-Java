//  Problem
// Given a 2D array A[M][N],aka Grid/Maze/Matrix

// Write an algorithm to count the number of unique paths to reach A[M-1][N-1]from A[0][0]

// At any cell(x,y),you can either go to(x+1,y)or(x,y+1)

public class GridWays {

  public static int countWays(int row, int col, int n, int m) {
    // base case
    if (row == n - 1 && col == m - 1) {
      return 1;
    } else if (row == n || col == m) {
      return 0;
    }

    int choice1 = countWays(row + 1, col, n, m);
    int choice2 = countWays(row, col + 1, n, m);
    int totalWays = choice1 + choice2;

    return totalWays;
  }

  public static void main(String[] args) {
    int n = 3, m = 3;

    System.out.println("Total ways: " + countWays(0, 0, n, m));
  }

}
