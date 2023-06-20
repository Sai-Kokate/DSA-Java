public class CircularQueueUsingArray {
  static class Queue {
    static int q[];
    static int size;
    static int rear;
    static int front;

    public Queue(int n) {
      q = new int[n];
      size = n;
      rear = -1;
      front = -1;
    }

    public static boolean isEmpty() {
      return rear == -1 && front == -1;
    }

    public static boolean isFull() {
      return (rear + 1) % size == front;
    }

    public static void add(int data) {
      if (isFull()) {
        System.out.println("Queue is Full!");
        return;
      }
      if (front == -1) {
        front = 0;
      }
      rear = (rear + 1) % size;
      q[rear] = data;

    }

    public static int remove() {

      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }

      int result = q[front];

      // if last element is getting removed
      if (rear == front) {
        rear = front = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;

    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }
      return q[front];

    }
  }

  public static void main(String[] args) {
    Queue newQueue = new Queue(5);

    newQueue.add(4);
    newQueue.add(5);
    newQueue.add(3);
    System.out.println(newQueue.remove());
    newQueue.add(7);
    System.out.println(newQueue.remove());
    newQueue.add(9);

    while (!newQueue.isEmpty()) {
      System.out.print(newQueue.peek() + " ");
      newQueue.remove();
    }
  }
}
