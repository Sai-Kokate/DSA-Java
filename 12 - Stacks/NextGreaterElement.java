import java.util.Stack;

public class NextGreaterElement {

  public static void findNextGreaterElement(int arr[], int nextGreater[]) { // TC = O(n)
    Stack<Integer> s = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      // check if stack isnt empty and the number present at the current index is
      // greater than elements present at indexes in stack
      while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nextGreater[i] = -1;
      } else {
        nextGreater[i] = arr[s.peek()];
      }

      s.push(i);
    }

  }

  public static void main(String[] args) {
    int arr[] = { 7, 4, 6, 8, 9, 0, 1, 3, 9, 6, 5, 3, 4, 2, 8 };
    int nextGreater[] = new int[arr.length];

    findNextGreaterElement(arr, nextGreater);

    for (int index = 0; index < arr.length; index++) {
      System.out.print(arr[index] + " ");

    }
    System.out.println();
    for (int i = 0; i < nextGreater.length; i++) {
      System.out.print(nextGreater[i] + " ");

    }
  }
}
