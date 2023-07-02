import java.util.*;

public class LongestIncreasingSubsequence {

  public static int lcs(int arr1[], int arr2[]) {
    int n = arr1.length;
    int m = arr2.length;
    int dp[][] = new int[n + 1][m + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (arr1[i - 1] == arr2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }

  public static int lis(int arr[]) {
    HashSet<Integer> hs = new HashSet<>();

    for (int j = 0; j < arr.length; j++) {
      hs.add(arr[j]);
    }

    int arr2[] = new int[hs.size()];

    int i = 0;
    for (int num : hs) {
      arr2[i] = num;
      i++;
    }

    Arrays.sort(arr2);
    return lcs(arr, arr2);
  }

  public static void main(String[] args) {
    int arr[] = { 50, 3, 10, 7, 40, 80 };

    System.out.println("LIS: " + lis(arr));
  }
}
