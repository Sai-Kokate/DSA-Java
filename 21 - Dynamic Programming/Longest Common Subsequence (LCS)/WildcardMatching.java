public class WildcardMatching {
  public static boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();
    boolean dp[][] = new boolean[n + 1][m + 1];
    // initalization
    dp[0][0] = true;

    // p = " "
    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = false;
    }

    // s = " "
    for (int j = 1; j < dp[0].length; j++) {
      // case1
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1];
      } else { // other cases
        dp[0][j] = false;
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          // ignore the * char
          boolean ans1 = dp[i][j - 1];
          // consider/match the * char, replace it with another char or sequence
          boolean ans2 = dp[i - 1][j];

          dp[i][j] = ans1 || ans2;
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    String s = "baaabab";
    String p = "*****ba*****ab"; // true

    System.out.println(isMatch(s, p));
  }
}
