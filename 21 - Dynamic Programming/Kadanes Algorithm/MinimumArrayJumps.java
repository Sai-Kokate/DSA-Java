import java.util.*;

public class MinimumArrayJumps {
  public static int caclMinJumps(int arr[]) {
    int n = arr.length;
    int dp[] = new int[n];

    for (int i = 0; i < dp.length; i++) {
      dp[i] = -1;
    }

    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
      System.out.println("i = " + i);
      int steps = arr[i];
      int ans = Integer.MAX_VALUE;
      for (int j = i + 1; j <= i + steps && j < n; j++) {
        System.out.println("i,j - " + i + "," + j);
        if (dp[j] != -1) {
          ans = Math.min(ans, dp[j] + 1);
          System.out.println(ans);
        }
      }
      if (ans != Integer.MAX_VALUE) {
        dp[i] = ans;
        System.out.println("dp[" + i + "] = " + ans);
      }
    }

    return dp[0];
  }

  public static void main(String[] args) {
    int arr[] = { 2, 3, 1, 1, 4 };
    System.out.println("Minimum Jums Required: " + caclMinJumps(arr));
  }
}