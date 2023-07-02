import java.util.Arrays;

public class CountingStairs {

  public static int countWays(int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return 0;
    }

    return countWays(n - 1) + countWays(n - 2);
  }

  public static int waysMemoization(int n, int ways[]) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return 0;
    }

    if (ways[n] != -1) {
      return ways[n];
    }

    ways[n] = waysMemoization(n - 1, ways) + waysMemoization(n - 2, ways);
    return ways[n];
  }

  public static int waysTabulation(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      if (i == 1) {
        dp[i] = dp[i - 1] + 0;
      } else {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 5;
    int ways[] = new int[n + 1];
    Arrays.fill(ways, -1);
    System.out.println(countWays(n));
    System.out.println(waysMemoization(n, ways));
    System.out.println(waysTabulation(n));

  }
}
