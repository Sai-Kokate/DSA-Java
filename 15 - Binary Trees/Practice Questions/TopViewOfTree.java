import java.security.cert.CRLReason;
import java.util.*;

public class TopViewOfTree {

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
    Node node;
    int hd;

    public Info(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  public static void topView(Node root) {
    // Level Order Traversal
    Queue<Info> q = new LinkedList<>();

    HashMap<Integer, Node> map = new HashMap<>();

    int min = 0, max = 0;

    q.add(new Info(root, 0));
    q.add(null);

    while (!q.isEmpty()) {
      Info currInfo = q.remove();

      if (currInfo == null) {
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        if (!map.containsKey(currInfo.hd)) { // first time hd is occuring
          map.put(currInfo.hd, currInfo.node); // adding node which occurs first time at this hd
        }

        if (currInfo.node.left != null) {
          q.add(new Info(currInfo.node.left, currInfo.hd - 1));
          min = Math.min(min, currInfo.hd - 1);
        }

        if (currInfo.node.right != null) {
          q.add(new Info(currInfo.node.right, currInfo.hd + 1));
          max = Math.max(max, currInfo.hd + 1);
        }

      }

    }

    for (int i = min; i <= max; i++) {
      System.out.print(map.get(i).data + " ");
    }

    System.out.println();

  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    topView(root);
  }

}
