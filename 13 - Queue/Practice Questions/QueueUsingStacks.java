import java.util.Stack;

public class QueueUsingStacks {

  static class Queue {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty() {
      return s1.isEmpty();
    }

    public static void add(int data) {

      // trasfer from s1 to s2
      while (!s1.isEmpty()) {
        int temp = s1.pop();
        s2.push(temp);
      }

      // add element to s1
      s1.push(data);

      // trasfer back from s2 to s1
      while (!s2.isEmpty()) {
        int temp = s2.pop();
        s1.push(temp);
      }
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is Empty!");
        return -1;
      }

      return s1.pop();
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is Empty!");
        return -1;
      }

      return s1.peek();

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
