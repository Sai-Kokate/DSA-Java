public class LargestBSTinaBT {
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

  static class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    public Info(boolean isBST, int size, int min, int max) {
      this.isBST = isBST;
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  public static int maxSize = 0;

  public static Info largestBST(Node root) {
    if (root == null) {
      System.out.println("Returning when root == null");
      return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    System.out.println("Printing root data: " + root.data);
    Info leftInfo = largestBST(root.left);
    Info rightInfo = largestBST(root.right);

    int size = leftInfo.size + rightInfo.size + 1;
    int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
    int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
    boolean isBST;
    // is BST

    if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max &&
        root.data < rightInfo.min) {
      isBST = true;
      maxSize = Math.max(maxSize, size); // update the max size when isBST is true
    } else {
      isBST = false;
    }
    System.out.println("Printing data: " + size + ", " + min + ", " + max + ", " + isBST);

    return new Info(isBST, size, min, max);
  }

  public static void main(String[] args) {
    Node root = new Node(50);
    root.left = new Node(30);
    root.right = new Node(60);
    root.left.left = new Node(5);
    root.left.right = new Node(20);
    root.right.left = new Node(45);
    root.right.right = new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right = new Node(80);

    Info info = largestBST(root);

    System.out.println("\n Size of largest BST = " + maxSize); // ans - 5
  }
}
