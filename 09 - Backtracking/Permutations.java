public class Permutations {

  static int count = 0;

  public static void printPermutations(String str, String ans) {
    // basecase
    if (str.length() == 0) {
      count++;
      System.out.println(ans);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char curr = str.charAt(i);
      String Newstr = str.substring(0, i) + str.substring(i + 1); // reducing the string in every recursion call
      printPermutations(Newstr, ans + curr);
    }
  }

  public static void main(String[] args) {
    String str = "abc";

    printPermutations(str, "");

    System.out.println("Total permutations: " + count);
  }
}
