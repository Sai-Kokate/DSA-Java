public class PrintInRange {
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

  public static void printRange(Node root, int n1, int n2) {
    if (root == null) {
      return;
    }

    if (root.data >= n1 && root.data <= n2) {
      printRange(root.left, n1, n2);
      System.out.print(root.data + " ");
      printRange(root.right, n1, n2);
    }

    if (root.data > n2) {
      printRange(root.left, n1, n2);
    }

    if (root.data < n1) {
      printRange(root.right, n1, n2);
    }

  }

  public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;

    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    inorder(root);
    System.out.println();
    printRange(root, 5, 10);
  }
}
