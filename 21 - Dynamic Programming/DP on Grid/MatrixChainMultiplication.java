import java.util.*;

public class MatrixChainMultiplication {

  public static void print(int dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void print(boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static int mcmRec(int arr[], int i, int j) {
    if (i == j) {
      return 0; // single matrix case
    }

    int ans = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int cost1, cost2, cost3, finalCost;
      cost1 = mcmRec(arr, i, k); // Ai .... Ak -> arr[i-1]*arr[k]
      cost2 = mcmRec(arr, k + 1, j); // Ak+1 ... Aj -> ar[k]*arr[j]
      cost3 = arr[i - 1] * arr[k] * arr[j];
      finalCost = cost1 + cost2 + cost3;
      ans = Math.min(ans, finalCost);
    }

    return ans;
  }

  public static int mcmMem(int arr[], int i, int j, int dp[][]) {
    if (i == j) {
      return 0;
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int ans = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int cost1, cost2, cost3, finalCost;
      cost1 = mcmMem(arr, i, k, dp); // Ai .... Ak -> arr[i-1]*arr[k]
      cost2 = mcmMem(arr, k + 1, j, dp); // Ak+1 ... Aj -> ar[k]*arr[j]
      cost3 = arr[i - 1] * arr[k] * arr[j];
      finalCost = cost1 + cost2 + cost3;
      ans = Math.min(ans, finalCost);
    }

    return dp[i][j] = ans;
  }

  public static int mcmTab(int arr[]) {
    int n = arr.length;

    int dp[][] = new int[n][n];

    // initialization
    for (int k = 0; k < dp.length; k++) {
      dp[k][k] = 0;
    }

    for (int len = 2; len <= n - 1; len++) {
      for (int i = 1; i <= n - len; i++) {
        int j = i + len - 1;// col
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int c1 = dp[i][k];
          int c2 = dp[k + 1][j];
          int c3 = arr[i - 1] * arr[k] * arr[j];
          dp[i][j] = Math.min(dp[i][j], c1 + c2 + c3);
        }
      }
    }

    print(dp);
    return dp[1][n - 1];
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 3 };
    int n = arr.length;
    int dp[][] = new int[n][n];

    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println("Mininmum cost of matrix multiplication: " + mcmRec(arr, 1, n - 1));
    System.out.println("MCM Memoization: " + mcmMem(arr, 1, n - 1, dp));
    print(dp);
    System.out.println();
    System.out.println("MCM Tablutaion: " + mcmTab(arr));
  }
}
