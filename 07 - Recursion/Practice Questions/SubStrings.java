// We are given a string S, we need to find the count of all contiguous substrings
// starting and ending with the same character.
// Sample Input 1 : S = "abcab"
// Sample Output 1 : 7
// There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b
// Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a and b. So, only 7
// contiguous substrings start and end with the same character.

public class SubStrings {

  public static int countSubString(String str, int si, int ei, int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    int res = countSubString(str, si + 1, ei, n - 1) +
        countSubString(str, si, ei - 1, n - 1) -
        countSubString(str, si + 1, ei - 1, n - 2);

    if (str.charAt(si) == str.charAt(ei)) {
      res++;
    }
    return res;
  }

  public static void main(String[] args) {
    String S = "abcab";
    System.out.println(countSubString(S, 0, S.length() - 1, S.length()));

  }
}
