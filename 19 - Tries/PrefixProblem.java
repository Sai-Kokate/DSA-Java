public class PrefixProblem {
  static class Node {
    Node childern[] = new Node[26];
    boolean eow;
    int freq;

    public Node() {
      for (int i = 0; i < childern.length; i++) {
        childern[i] = null;
      }
      freq = 1;
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (curr.childern[idx] == null) {
        curr.childern[idx] = new Node();
      } else {
        curr.childern[idx].freq++; // updating frequency of each char node , if it appears again in a trie
      }
      curr = curr.childern[idx];
    }
  }

  public static void findPrefix(Node root, String ans) {
    if (root == null) {
      return;
    }

    if (root.freq == 1) {
      System.out.print(ans + " ");
      return;
    }

    for (int i = 0; i < root.childern.length; i++) {
      if (root.childern[i] != null) {
        findPrefix(root.childern[i], ans + (char) (i + 'a'));
      }
    }
  }

  public static void main(String[] args) {
    String words[] = { "zebra", "dog", "dove", "duck" };

    for (int i = 0; i < words.length; i++) {
      insert(words[i]);
    }

    root.freq = -1; // setting freq of root to -1
    findPrefix(root, "");
  }
}
