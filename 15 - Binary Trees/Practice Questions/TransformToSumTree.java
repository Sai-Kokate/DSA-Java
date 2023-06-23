public class TransformToSumTree {
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

  public static int transform(Node root) {
    if (root == null) {
      return 0;
    }

    int leftChild = transform(root.left);
    int rightChild = transform(root.right);

    int newLeft = root.left == null ? 0 : root.left.data;
    int newRight = root.right == null ? 0 : root.right.data;

    int data = root.data;

    root.data = leftChild + newLeft + rightChild + newRight;

    return data;

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
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    int n = 4, k = 2;

    transform(root);
    preorder(root);
  }

}
