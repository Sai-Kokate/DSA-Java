public class StackLinkedList {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static class Stack {
    static Node head = null;

    public static boolean isEmpty() {
      return head == null;
    }

    public static void push(int data) {
      Node newNode = new Node(data);
      if (isEmpty()) {
        head = newNode;
        return;
      }

      newNode.next = head;
      head = newNode;
    }

    public static int pop() {
      if (isEmpty()) {
        return -1;
      }

      int top = head.data;
      head = head.next;
      return top;
    }

    public static int peek() {
      if (isEmpty()) {
        return -1;
      }

      return head.data;
    }
  }

  public static void main(String[] args) {
    Stack newStack = new Stack();

    newStack.push(1);
    newStack.push(2);

    newStack.push(3);

    while (!newStack.isEmpty()) {
      System.out.println(newStack.peek());
      newStack.pop();
    }
  }
}
