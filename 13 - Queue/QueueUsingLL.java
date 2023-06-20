import java.util.Queue;

public class QueueUsingLL {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static class Queue {
    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty() {
      return head == null && tail == null;
    }

    public static void add(int data) {
      Node newNode = new Node(data);
      // if first element
      if (head == null) {
        head = tail = newNode;
        return;
      }

      tail.next = newNode;
      tail = newNode;
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }

      int res = head.data;

      // if single element
      if (head == tail) {
        head = tail = null;
      } else {
        head = head.next;
      }
      return res;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }

      return head.data;

    }
  }

  public static void main(String[] args) {
    Queue newQueue = new Queue();

    newQueue.add(1);
    newQueue.add(2);
    newQueue.add(3);

    while (!newQueue.isEmpty()) {
      System.out.println(newQueue.peek());
      newQueue.remove();
    }
  }
}
