public class TargetSumSubset {
  public static void print(boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static boolean tabTargetSum(int num[], int target) {
    int n = num.length;
    boolean dp[][] = new boolean[n + 1][target + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j == 0) {
          dp[i][j] = true;
        } else if (j > 0 && i == 0) {
          dp[i][j] = false;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < target + 1; j++) {
        int v = num[i - 1];
        if (v <= j && dp[i - 1][j - v] == true) { // valid case
          dp[i][j] = true;
        } else if (dp[i - 1][j] == true) {
          dp[i][j] = true;
        }
      }
    }

    print(dp);
    return dp[n][target];
  }

  public static void main(String[] args) {
    int num[] = { 4, 2, 7, 1, 3 };
    int target = 10;

    System.out.println(tabTargetSum(num, target));
  }
}
