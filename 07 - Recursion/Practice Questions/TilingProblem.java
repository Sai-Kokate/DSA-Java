// Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile. 

public class TilingProblem {

  public static int noOfWays(int n) {
    // basecase
    if (n <= 2) {
      return n;
    }

    // choices
    // placing a tile vertically , remaining width to fill : n-1
    int nm1 = noOfWays(n - 1);

    // placing a tile horizontally , remaining width to fill : n-2
    int nm2 = noOfWays(n - 2);

    // total ways
    int totalWays = nm1 + nm2;

    return totalWays;

  }

  public static void main(String[] args) {

    int n = 8;

    System.out.println(noOfWays(n));

  }
}
