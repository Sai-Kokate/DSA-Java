public class CountingSort {
  public static void printArray(int num[]) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
  }

  public static void countingSort(int num[]) {
    int n = num.length;
    int largest = Integer.MIN_VALUE;
    // finding out largest element in array
    for (int i = 0; i < n; i++) {
      largest = Math.max(largest, num[i]);
    }

    // creating count array
    int count[] = new int[largest + 1]; // n+1 length as we have to include zero as well

    for (int i = 0; i < n; i++) {
      count[num[i]]++;
    }

    int j = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        num[j] = i;
        j++;
        count[i]--;
      }
    }

    System.out.println("Sorted Array: ");
    printArray(num);
  }

  public static void main(String[] args) {
    int arr[] = { 3, 6, 2, 8, 7, 4, 5, 3, 1, 9, 1, 5, 6, 8 };

    countingSort(arr);
  }

}
