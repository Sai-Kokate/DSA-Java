// ApplyMergesorttosortanarrayofStrings.(Assumethatallthecharactersinall the Strings are in lowercase). (EASY)Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}Sample Output 1: arr = { "earth", "mars", "mercury","sun"

public class Assignment {
  public static void printArray(String arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");

    }
    System.out.println();
  }

  public static void mergeSort(String arr[], int si, int ei) {

    int mid = si + (ei - si) / 2;

    if (si >= ei) {
      return;
    }

    mergeSort(arr, si, mid);
    mergeSort(arr, mid + 1, ei);
    merge(arr, si, mid, ei);
  }

  public static void merge(String arr[], int si, int mid, int ei) {
    String temp[] = new String[ei - si + 1];
    int i = si; // iterator for left part
    int j = mid + 1; // iterator for right part
    int k = 0; // iterator for temp array

    while (i <= mid && j <= ei) {
      if (arr[i].compareTo(arr[j]) < 0) {
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
    String arr[] = { "sun", "earth", "mars", "mercury" };
    mergeSort(arr, 0, arr.length - 1);
    printArray(arr); // op -> { "earth", "mars", "mercury","sun"}

  }

}
