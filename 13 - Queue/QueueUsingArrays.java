public class QueueUsingArrays {
  static class Queue {
    static int q[];
    static int size;
    static int rear;

    public Queue(int n) {
      q = new int[n];
      size = n;
      rear = -1;
    }

    public static boolean isEmpty() {
      return rear == -1;
    }

    public static void add(int data) {
      if (rear == size - 1) {
        System.out.println("Queue is Full!");
        return;
      }
      rear = rear + 1;
      q[rear] = data;

    }

    public static int remove() {

      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }

      int front = q[0];
      for (int i = 0; i < rear; i++) {
        q[i] = q[i + 1];
      }
      rear = rear - 1;
      return front;

    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }
      return q[0];

    }
  }

  public static void main(String[] args) {
    Queue newQueue = new Queue(5);

    newQueue.add(1);
    newQueue.add(2);
    newQueue.add(3);

    while (!newQueue.isEmpty()) {
      System.out.println(newQueue.peek());
      newQueue.remove();
    }
  }
}