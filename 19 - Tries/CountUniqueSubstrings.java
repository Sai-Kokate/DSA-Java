public class CountUniqueSubstrings {
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

  public static int countNodes(Node root) {
    if (root == null) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (root.childern[i] != null) {
        count += countNodes(root.childern[i]);
      }
    }

    return count + 1;
  }

  public static void main(String[] args) {
    String str = "ababa";

    for (int i = 0; i < str.length(); i++) {
      String suffix = str.substring(i);
      insert(suffix);
    }

    System.out.println("No. of unique suffixes: " + countNodes(root));
  }
}
