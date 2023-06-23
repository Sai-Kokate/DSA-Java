import java.util.*;

public class BuildTreePreorder {

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

  static class BinaryTree {
    static int idx = -1;

    public static Node buildTree(int nodes[]) {
      idx++;

      if (nodes[idx] == -1) {
        return null;
      }

      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }

    public static void preorder(Node root) { // TC = O(n)
      // basecase
      if (root == null) {
        // System.out.print("-1 ");
        return;
      }

      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
    }

    public static void inorder(Node root) {
      // basecase
      if (root == null) {
        // System.out.print("-1 ");
        return;
      }

      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);

    }

    public static void postorder(Node root) {
      // basecase
      if (root == null) {
        // System.out.print("-1 ");
        return;
      }

      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");

    }

    // lvel order traversal
    public static void levelOrder(Node root) {
      // basecase
      if (root == null) {
        // System.out.print("-1 ");
        return;
      }

      Queue<Node> q = new LinkedList<>();

      q.add(root);
      q.add(null);

      while (!q.isEmpty()) {
        Node currNode = q.remove();
        if (currNode == null) {
          System.out.println();
          if (q.isEmpty()) {
            break;
          } else {
            q.add(null);
          }
        } else {
          System.out.print(currNode.data + " ");
          if (currNode.left != null) {
            q.add(currNode.left);
          }
          if (currNode.right != null) {
            q.add(currNode.right);
          }
        }
      }
    }

    public static int height(Node root) {
      // basecase
      if (root == null) {
        return 0;
      }

      int lh = height(root.left);
      int rh = height(root.right);
      int ht = Math.max(lh, rh) + 1;

      return ht;
    }

    public static int count(Node root) {
      if (root == null) {
        return 0;
      }

      int lc = count(root.left);
      int rc = count(root.right);
      int treeCount = lc + rc + 1;

      return treeCount;
    }

    public static int sum(Node root) {
      if (root == null) {
        return 0;
      }

      int ls = sum(root.left);
      int rs = sum(root.right);
      int treeSum = ls + rs + root.data;

      return treeSum;

    }

    public static int diameter(Node root) { // O(n^2)
      if (root == null) {
        return 0;
      }

      int ldia = diameter(root.left);
      int rdia = diameter(root.right);
      int lh = height(root.left);
      int rh = height(root.right);
      int selfDia = lh + rh + 1;

      return Math.max(selfDia, Math.max(rdia, ldia));
    }

    static class Info {
      int dia;
      int ht;

      public Info(int d, int h) {
        this.dia = d;
        this.ht = h;
      }
    }

    public static Info diameterOptimised(Node root) {

      if (root == null) {
        return new Info(0, 0);
      }

      Info leftInfo = diameterOptimised(root.left);
      Info rightInfo = diameterOptimised(root.right);

      int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
      int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

      return new Info(dia, ht);
    }
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    BinaryTree bt = new BinaryTree();
    Node root = bt.buildTree(nodes);
    System.out.println(root.data);

    bt.preorder(root);
    System.out.println();
    bt.inorder(root);
    System.out.println();
    bt.postorder(root);
    System.out.println();
    bt.levelOrder(root);
    System.out.println("Tree Height : " + bt.height(root));
    System.out.println("No. of Nodes : " + bt.count(root));
    System.out.println("Sum of Nodes : " + bt.sum(root));
    System.out.println("Diameter : " + bt.diameter(root));
    System.out.println("Optimised Diameter: " + bt.diameterOptimised(root).dia);

  }
}