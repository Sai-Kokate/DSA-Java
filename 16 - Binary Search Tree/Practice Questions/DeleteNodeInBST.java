
public class DeleteNodeInBST {
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

  public static Node findInorderSuccessor(Node root) {
    // leftmost node in the right subtree
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static Node deleteNode(Node root, int key) {

    if (root.data > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.data < key) {
      root.right = deleteNode(root.right, key);
    } else {
      // Leaf node - zero child - return null to the parent - node will be deleted
      if (root.left == null && root.right == null) {
        return null;
      }

      // one child - return the child of the node to the parent - the node will be
      // deleted
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      // two childs - find Inorde Successor - replace root data with IS data - delete
      // IS node
      Node IS = findInorderSuccessor(root); // leftmost node in the right subtree
      root.data = IS.data;
      root.right = deleteNode(root.right, IS.data);
    }

    return root;
  }

  public static void main(String[] args) {
    int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;

    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    inorder(root);
    deleteNode(root, 10);
    System.out.println();
    inorder(root);
  }
}
