public class StringConversion {
  public static int lcsTabulation(String str1, String str2) {

    int n = str1.length();
    int m = str2.length();

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
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }

  public static void countMinWays(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();

    int lcs = lcsTabulation(str1, str2);

    System.out.println("Min deletion operations: " + (n - lcs));
    System.out.println("Min addition operations: " + (m - lcs));

  }

  public static void main(String[] args) {
    String str1 = "abcdef";
    String str2 = "aceg";

    System.out.println("Min. No. of operations to convert str1->str2: ");
    countMinWays(str1, str2);
  }
}
