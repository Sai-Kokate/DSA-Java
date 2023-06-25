public class LongestWordWithAllPrefixes {
  static class Node {
    Node childern[] = new Node[26];
    boolean eow = false;

    Node() {
      for (int i = 0; i < childern.length; i++) {
        childern[i] = null;
      }
    }
  }

  public static Node root = new Node();

  public static void insert(String word) { // O(L)
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int idx = word.charAt(level) - 'a';
      if (curr.childern[idx] == null) {
        curr.childern[idx] = new Node(); // creating a new node , at place of the character in the word
      }
      curr = curr.childern[idx]; // updating current to the Node created according to the character in the word
    }

    curr.eow = true; // when word ends , eow = true
  }

  public static boolean search(String key) { // O(L)
    Node curr = root;
    for (int i = 0; i < key.length(); i++) {
      int idx = key.charAt(i) - 'a';
      if (curr.childern[idx] == null) {
        return false;
      }
      curr = curr.childern[idx];
    }

    if (curr.eow) {
      return true;
    } else {
      return false;
    }
  }

  public static String ans = "";

  public static void longestWord(Node root, StringBuilder temp) {
    if (root == null) {
      return;
    }

    for (int i = 0; i < root.childern.length; i++) {
      if (root.childern[i] != null && root.childern[i].eow == true) {
        temp.append((char) (i + 'a'));
        if (temp.length() > ans.length()) { // update final answer
          ans = temp.toString();
        }
        longestWord(root.childern[i], temp); // recursive call to child node
        temp.deleteCharAt(temp.length() - 1); // backtrack
      }
    }
  }

  public static void main(String[] args) {
    String str[] = { "a", "banana", "app", "appl", "ap", "apple", "apply" };

    for (int i = 0; i < str.length; i++) {
      insert(str[i]);
    }

    longestWord(root, new StringBuilder(""));
    System.out.println(ans);
  }
}
