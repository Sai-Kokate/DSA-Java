import java.util.*;

public class ValidateBST {
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

  public static boolean validate(Node root, Node min, Node max) {
    if (root == null) {
      return true;
    }

    if (min != null && root.data <= min.data) {
      return false;
    }

    if (max != null && root.data >= max.data) {
      return false;
    }

    return validate(root.left, min, root) && validate(root.right, root, max);
  }

  public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;

    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    inorder(root);
    System.out.println(validate(root, null, null));
  }
}
