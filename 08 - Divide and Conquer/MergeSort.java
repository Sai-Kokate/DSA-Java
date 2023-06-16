public class MergeSort {
  public static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");

    }
    System.out.println();
  }

  public static void mergeSort(int arr[], int si, int ei) {
    // base case
    if (si >= ei) {
      return;
    }

    int mid = si + (ei - si) / 2;
    // left part
    mergeSort(arr, si, mid);
    // right part
    mergeSort(arr, mid + 1, ei);

    // merge operation
    merge(arr, si, mid, ei);
  }

  public static void merge(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int i = si; // iterator for left part
    int j = mid + 1; // iterator for right part
    int k = 0; // iterator for temp array

    while (i <= mid && j <= ei) {
      if (arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    while (j <= ei) {
      temp[k++] = arr[j++];
    }

    for (int k2 = 0, i2 = si; k2 < temp.length; k2++, i2++) {
      arr[i2] = temp[k2];

    }
  }

  public static void main(String[] args) {
    int arr[] = { 2, 8, 9, 4, 5, 6, 7, 3, 2, 1, 5 };

    mergeSort(arr, 0, arr.length - 1);
    printArray(arr);
  }

}
