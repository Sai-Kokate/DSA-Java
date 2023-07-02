public class UnboundedKnapsack {

  public static void print(int dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static int recUnboundedKnapsack(int wt[], int val[], int W, int n) { // O(2^n)
    if (W == 0 || n == 0) {
      return 0;
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + recUnboundedKnapsack(wt, val, W - wt[n - 1], n);
      // exclude
      int ans2 = recUnboundedKnapsack(wt, val, W, n - 1);
      return Math.max(ans1, ans2);
    } else {
      return recUnboundedKnapsack(wt, val, W, n - 1);
    }
  }

  public static int memoizeUnboundedKnapsack(int wt[], int val[], int W, int n, int dp[][]) { // O(n*W)
    if (n == 0 || W == 0) {
      return 0;
    }

    if (dp[n][W] != -1) {
      return dp[n][W];
    }

    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + memoizeUnboundedKnapsack(wt, val, W - wt[n - 1], n, dp);
      // exclude
      int ans2 = memoizeUnboundedKnapsack(wt, val, W, n - 1, dp);

      return dp[n][W] = Math.max(ans1, ans2);
    } else {
      return dp[n][W] = memoizeUnboundedKnapsack(wt, val, W, n - 1, dp);
    }
  }

  public static int tabulationUnboundedKnapsack(int wt[], int val[], int W) {
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
          int includePrice = v + dp[i][j - w];
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

    System.out.println(recUnboundedKnapsack(wt, val, W, val.length));
    System.out.println(memoizeUnboundedKnapsack(wt, val, W, val.length, dp));
    System.out.println(tabulationUnboundedKnapsack(wt, val, W));

  }
}
