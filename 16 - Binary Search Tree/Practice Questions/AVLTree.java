import java.util.*;

public class AVLTree {
  static class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
      this.data = data;
      height = 1;

    }
  }

  public static Node root;

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    return root.height;
  }

  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  public static int getBalanceFactor(Node root) {
    if (root == null) {
      return 0;
    }

    return height(root.left) - height(root.right);
  }

  // left rotate subtree rooted with Node x
  public static Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // perform rotation
    y.left = x;
    x.right = T2;

    // update heights
    x.height = 1 + max(height(x.left), height(x.right));
    y.height = 1 + max(height(y.left), height(y.right));

    // return new root
    return y;
  }

  // right rotate subtree rooted with Node y
  public static Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // perform rotation
    x.right = y;
    y.left = T2;

    // update heights
    x.height = 1 + max(height(x.left), height(x.right));
    y.height = 1 + max(height(y.left), height(y.right));

    // return new root
    return x;
  }

  public static Node insert(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }

    if (key < root.data) {
      root.left = insert(root.left, key);
    } else if (key > root.data) {
      root.right = insert(root.right, key);
    } else {
      return root; // duplicate keys not allowed
    }

    // update root height
    root.height = 1 + Math.max(height(root.left), height(root.right));

    // claculate balance factor
    int bf = getBalanceFactor(root);

    // Left Left Case
    if (bf > 1 && root.left.data > key) {
      // right rotation
      return rightRotate(root);
    }

    // Right Right Case
    if (bf < -1 && root.right.data < key) {
      // left rotation
      return leftRotate(root);
    }

    // Left Right Case
    if (bf > 1 && root.left.data < key) {
      // left rotation and then right rotation
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // Right Left Case
    if (bf < -1 && root.right.data > key) {
      // right rotation and then left rotation
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root; // returned if AVL is balanced
  }

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void main(String[] args) {
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    preorder(root);
  }
}
