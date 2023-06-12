public class SelectionSort {
  public static void printArray(int num[]) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void selectionSort(int num[]) {
    int n = num.length;

    for (int i = 0; i < n - 1; i++) {
      int minPos = i;

      for (int j = i + 1; j < n; j++) {
        if (num[j] <= num[minPos]) {
          minPos = j;
        }
      }

      // swap
      int temp = num[minPos];
      num[minPos] = num[i];
      num[i] = temp;

    }

    System.out.println("Sorted Array: ");

    printArray(num);
  }

  public static void main(String[] args) {
    int arr[] = { 3, 6, 2, 8, 7, 4, 5, 3, 1, 9, 1, 5, 6, 8 };

    selectionSort(arr);
  }
}
