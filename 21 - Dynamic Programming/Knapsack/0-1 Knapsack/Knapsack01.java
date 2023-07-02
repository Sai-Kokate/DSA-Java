public class Knapsack01 {

  public static void print(int dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static int rec01Knapsack(int wt[], int val[], int W, int n) { // O(2^n)
    if (W == 0 || n == 0) {
      return 0;
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + rec01Knapsack(wt, val, W - wt[n - 1], n - 1);
      // exclude
      int ans2 = rec01Knapsack(wt, val, W, n - 1);
      return Math.max(ans1, ans2);
    } else {
      return rec01Knapsack(wt, val, W, n - 1);
    }
  }

  public static int memoize01Knapsack(int wt[], int val[], int W, int n, int dp[][]) { // O(n*W)
    if (n == 0 || W == 0) {
      return 0;
    }

    if (dp[n][W] != -1) {
      return dp[n][W];
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + memoize01Knapsack(wt, val, W - wt[n - 1], n - 1, dp);
      // exclude
      int ans2 = memoize01Knapsack(wt, val, W, n - 1, dp);

      return dp[n][W] = Math.max(ans1, ans2);
    } else {
      return dp[n][W] = memoize01Knapsack(wt, val, W, n - 1, dp);
    }
  }

  public static int tabulation01Knapsack(int wt[], int val[], int W) {
    int n = val.length;
    int dp[][] = new int[n + 1][W + 1];

    // initialize
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < W + 1; j++) {
        int w = wt[i - 1];
        int v = val[i - 1];

        if (w <= j) { // valid
          // include
          int includePrice = v + dp[i - 1][j - w];
          // exclude
          int excludePrice = dp[i - 1][j];

          dp[i][j] = Math.max(includePrice, excludePrice);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    print(dp);
    return dp[n][W];
  }

  public static void main(String[] args) {
    int wt[] = { 2, 5, 1, 3, 4 };
    int val[] = { 15, 14, 10, 45, 30 };

    int W = 7;

    int dp[][] = new int[val.length + 1][W + 1];

    // initialize
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }

    System.out.println(rec01Knapsack(wt, val, W, val.length));
    System.out.println(memoize01Knapsack(wt, val, W, val.length, dp));
    System.out.println(tabulation01Knapsack(wt, val, W));

  }
}