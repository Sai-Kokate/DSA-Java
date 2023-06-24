import java.util.*;

public class HeapSort {
  public static void heapifyMax(int arr[], int i, int size) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int maxIdx = i;

    if (left < size && arr[maxIdx] < arr[left]) {
      maxIdx = left;
    }
    if (right < size && arr[maxIdx] < arr[right]) {
      maxIdx = right;
    }

    if (maxIdx != i) {
      // swap
      int temp = arr[maxIdx];
      arr[maxIdx] = arr[i];
      arr[i] = temp;

      heapifyMax(arr, maxIdx, size);
    }

  }

  public static void heapifyMin(int arr[], int i, int size) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int minIdx = i;

    if (left < size && arr[minIdx] > arr[left]) {
      minIdx = left;
    }
    if (right < size && arr[minIdx] > arr[right]) {
      minIdx = right;
    }

    if (minIdx != i) {
      // swap
      int temp = arr[minIdx];
      arr[minIdx] = arr[i];
      arr[i] = temp;

      heapifyMin(arr, minIdx, size);
    }

  }

  public static void heapSort(int arr[]) {

    // build a MaxHeap
    int n = arr.length;
    for (int i = n / 2; i >= 0; i--) {
      heapifyMin(arr, i, n);
    }

    // push largest element(first index) at end
    for (int i = n - 1; i > 0; i--) {
      // swap
      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;

      heapifyMin(arr, 0, i);

    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 4, 5, 3 };

    heapSort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
