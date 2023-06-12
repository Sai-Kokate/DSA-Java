import java.util.*;

public class InsertionSort {
  public static void printArray(int num[]) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void inserstionSort(int num[]) {
    int n = num.length;

    for (int i = 1; i < n; i++) {
      int curr = num[i];
      int prev = i - 1;

      while (prev >= 0 && num[prev] > curr) {
        // moving current number to its correct place
        num[prev + 1] = num[prev];
        prev--;
      }

      num[prev + 1] = curr;

    }

    System.out.println("Sorted Array: ");
    printArray(num);
  }

  public static void main(String[] args) {
    int arr[] = { 3, 6, 2, 8, 7, 4, 5, 3, 1, 9, 1, 5, 6, 8 };
    inserstionSort(arr);
  }
}
