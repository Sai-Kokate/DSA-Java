import java.util.*;

public class MirrorBST {
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

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");

    preorder(root.left);
    preorder(root.right);

  }

  public static Node mirror(Node root) {
    if (root == null) {
      return null;
    }

    Node leftST = mirror(root.left);
    Node rightST = mirror(root.right);

    root.left = rightST;
    root.right = leftST;

    return root;
  }

  public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;

    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    preorder(root);
    mirror(root);
    System.out.println();
    preorder(root);

  }
}
