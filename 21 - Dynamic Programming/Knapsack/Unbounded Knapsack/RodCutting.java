public class RodCutting {

  public static int calcMaxProfit(int len[], int price[], int rodLen) {
    int n = price.length;
    int dp[][] = new int[n + 1][rodLen + 1];

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;
    }

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (j >= len[i - 1]) {
          // include or exclude
          dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][rodLen];
  }

  public static void main(String[] args) {
    int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
    int rodLen = 8;

    System.out.println(calcMaxProfit(len, price, rodLen));
  }
}
