import java.util.*;

public class StackUsingQueues {
  static class Stack {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static boolean isEmpty() {
      return q1.isEmpty() && q2.isEmpty();
    }

    public static void push(int data) {
      // if (isEmpty()) {
      // q1.add(data);
      // return;
      // }
      // check which queue is not empty and add in that
      if (!q1.isEmpty()) {
        q1.add(data);
      } else {
        q2.add(data);
      }
    }

    public static int pop() {
      if (isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      int temp = -1;
      // check which queue is filled and transfer elements to other queue
      if (!q1.isEmpty()) {
        while (!q1.isEmpty()) {
          temp = q1.remove();
          if (q1.isEmpty()) {
            break;
          }
          q2.add(temp);
        }

      } else {
        while (!q2.isEmpty()) {
          temp = q2.remove();
          if (q2.isEmpty()) {
            break;
          }
          q1.add(temp);
        }
      }

      return temp;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      int temp = -1;
      // check which queue is filled and transfer elements to other queue
      if (!q1.isEmpty()) {
        while (!q1.isEmpty()) {
          temp = q1.remove();
          q2.add(temp);
        }

      } else {
        while (!q2.isEmpty()) {
          temp = q2.remove();
          q1.add(temp);
        }

      }

      return temp;

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
