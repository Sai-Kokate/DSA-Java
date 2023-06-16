public class SubSets { // TC = O(2^n)
  static int count = 0;

  public static void printSubSets(String str, String ans, int i) {
    // basecase
    if (i == str.length()) {
      count++;
      System.out.println("Substring No. " + count);
      if (ans.length() == 0) {
        System.out.println("null");
        return;
      } else {
        System.out.println(ans);
        return;
      }
    }

    // choice of an element : to be present in a substring or not
    // choice 1 : to be present in a substring
    printSubSets(str, ans + str.charAt(i), i + 1);

    // choice 2 : not to be present in a substring
    printSubSets(str, ans, i + 1);
  }

  public static void main(String[] args) {
    String str = "abc";

    printSubSets(str, "", 0);
    System.out.println("No. of substrings: " + count);
  }
}
