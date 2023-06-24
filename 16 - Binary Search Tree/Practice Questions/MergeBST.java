import java.util.*;

public class MergeBST {
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

  public static void createInorderSeq(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }

    createInorderSeq(root.left, arr);
    arr.add(root.data);
    createInorderSeq(root.right, arr);
  }

  public static void merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> fin) {
    int i = 0;
    int j = 0;

    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) <= arr2.get(j)) {
        fin.add(arr1.get(i));
        i++;
      } else {
        fin.add(arr2.get(j));
        j++;
      }
    }

    while (i < arr1.size()) {
      fin.add(arr1.get(i));
      i++;
    }

    while (j < arr2.size()) {
      fin.add(arr2.get(j));
      j++;
    }

  }

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");

    preorder(root.left);
    preorder(root.right);

  }

  public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
    if (si > ei) {
      return null;
    }

    int mid = si + (ei - si) / 2;
    Node root = new Node(arr.get(mid));
    root.left = createBST(arr, si, mid - 1);
    root.right = createBST(arr, mid + 1, ei);

    return root;
  }

  public static Node mergeBST(Node root1, Node root2) {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();

    createInorderSeq(root1, arr1);
    createInorderSeq(root2, arr2);

    ArrayList<Integer> fin = new ArrayList<>();
    merge(arr1, arr2, fin);
    Node root = createBST(fin, 0, fin.size() - 1);
    return root;
  }

  public static void main(String[] args) {
    Node root1 = new Node(2);
    root1.left = new Node(1);
    root1.right = new Node(4);

    Node root2 = new Node(9);
    root2.left = new Node(3);
    root2.right = new Node(12);

    Node root = mergeBST(root1, root2);

    preorder(root);
  }
}
