import java.rmi.Remote;
import java.util.ArrayList;

public class StackArrayList {

  static class Stack {
    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isEmpty() {
      return list.size() == 0;
    }

    public static void push(int data) {
      list.add(data);
    }

    public static int pop() {
      if (isEmpty()) {
        return -1;
      }

      int elem = list.get(list.size() - 1);
      list.remove(list.size() - 1);
      return elem;
    }

    public static int peek() {
      if (isEmpty()) {
        return -1;
      }

      int elem = list.get(list.size() - 1);
      return elem;

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