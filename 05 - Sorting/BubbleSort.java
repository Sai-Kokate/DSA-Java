import java.util.*;

public class BubbleSort {
  public static void printArray(int num[]) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void bubbleSort(int num[]) {
    int n = num.length;

    for (int i = 0; i < n - 1; i++) {

      for (int j = 0; j < n - 1 - i; j++) {
        if (num[j] > num[j + 1]) {
          // swaping
          int temp = num[j];
          num[j] = num[j + 1];
          num[j + 1] = temp;

        }
      }
    }

    System.out.println("Sorted Array: ");
    printArray(num);
  }

  public static void main(String[] args) {

    int arr[] = { 3, 6, 2, 8, 7, 4, 5, 3, 1, 9, 1, 5, 6, 8 };

    bubbleSort(arr);
  }
}