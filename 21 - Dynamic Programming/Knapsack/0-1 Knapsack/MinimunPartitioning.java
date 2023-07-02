import java.util.*;

public class MinimunPartitioning {

  public static int clacMinDiff(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    int W = sum / 2;

    int dp[][] = new int[n + 1][W + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (arr[i - 1] <= j) {// valid
          // include
          int ans1 = dp[i - 1][j - arr[i - 1]] + arr[i - 1];
          // exclude
          int ans2 = dp[i - 1][j];

          dp[i][j] = Math.max(ans1, ans2);

        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    int sum1 = dp[n][W];
    int sum2 = sum - sum1;

    return Math.abs(sum2 - sum1);
  }

  public static void main(String[] args) {
    int num[] = { 1, 6, 11, 5 };

    System.out.println("Mininmum Diff: " + clacMinDiff(num));

  }
}