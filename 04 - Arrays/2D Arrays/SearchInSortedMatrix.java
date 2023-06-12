import java.util.*;

public class SearchInSortedMatrix {
  public static void searchInSortedMatrix(int matrix[][], int target) {
    int row = 0;
    int col = matrix[0].length - 1;

    int startCol = 0;
    int endRow = matrix.length - 1;

    while (row <= endRow && col >= startCol) {
      if (matrix[row][col] == target) {
        System.out.println("Target found at index [" + row + "," + col + "]");
        return;
      } else {
        if (matrix[row][col] < target) {
          // move down
          row = row + 1;
        } else {
          // move left
          col = col - 1;
        }
      }
    }

    System.out.println("The target was NOT found!!");
  }

  public static void main(String[] args) {
    int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
    int target = 11;
    searchInSortedMatrix(matrix, target);
  }
}
