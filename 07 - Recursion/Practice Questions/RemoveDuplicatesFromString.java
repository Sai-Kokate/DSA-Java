public class RemoveDuplicatesFromString {

  public static void removeDuplicates(String str, int i, StringBuilder newStr, boolean map[]) {
    str = str.toLowerCase();
    if (i == str.length() - 1) {
      System.out.println(newStr);
      return;
    }

    char ch = str.charAt(i);

    // checking
    if (map[ch - 'a'] == true) {
      removeDuplicates(str, i + 1, newStr, map);
    } else {
      map[ch - 'a'] = true;
      removeDuplicates(str, i + 1, newStr.append(ch), map);
    }

  }

  public static void main(String[] args) {
    String str = "SaibalajiKokate";

    removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
  }
}
