import java.util.*;

public class MaxAreaInHistogram {

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void calculateNextSmallerLeft(int arr[], int nextSmallerLeft[]) {
    Stack<Integer> s = new Stack<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int currHt = arr[i];

      while (!s.isEmpty() && arr[s.peek()] >= currHt) {
        s.pop();
      }

      if (s.isEmpty()) {
        nextSmallerLeft[i] = -1;
      } else {
        nextSmallerLeft[i] = s.peek();
      }

      s.push(i);

    }
  }

  public static void calculateNextSmallerRight(int arr[], int nextSmallerRight[]) {
    Stack<Integer> s = new Stack<>();
    int n = arr.length;

    for (int i = n - 1; i >= 0; i--) {
      int currHt = arr[i];

      while (!s.isEmpty() && arr[s.peek()] > currHt) {
        s.pop();
      }

      if (s.isEmpty()) {
        nextSmallerRight[i] = n; // if no next samller ht is found then, the width would be total width
      } else {
        nextSmallerRight[i] = s.peek();
      }

      s.push(i);

    }

  }

  public static int maxReactanleArea(int arr[], int nextSmallerLeft[], int nextSmallerRight[]) {
    int max_area = 0;
    int areaArr[] = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int ht = arr[i];
      int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;

      int area = ht * width;
      areaArr[i] = area;
      max_area = Math.max(max_area, area);
    }

    printArr(areaArr);
    return max_area;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 1, 5, 6, 2, 3 };
    int nextSmallerRight[] = new int[arr.length];
    int nextSmallerLeft[] = new int[arr.length];

    calculateNextSmallerRight(arr, nextSmallerRight);
    calculateNextSmallerLeft(arr, nextSmallerLeft);

    printArr(arr);
    printArr(nextSmallerLeft);
    printArr(nextSmallerRight);

    int max_area = maxReactanleArea(arr, nextSmallerLeft, nextSmallerRight);

    System.out.println("Maximum area: " + max_area);

  }
}
