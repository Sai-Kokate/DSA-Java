import java.util.*;

public class RootToLeaf {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      // first node
      root = new Node(val);
      return root;
    }

    if (root.data > val) {
      // insert left
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }

    return root;
  }

  public static void inorder(Node root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);

  }

  public static void printPaths(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    // add root data to path
    path.add(root.data);
    if (root.left == null && root.right == null) {
      System.out.print(path);
      System.out.println();
    }
    printPaths(root.left, path);
    printPaths(root.right, path);
    path.remove(path.size() - 1);

  }

  public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;
    ArrayList<Integer> path = new ArrayList<>();

    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    inorder(root);
    System.out.println();

    printPaths(root, path);
  }
}
