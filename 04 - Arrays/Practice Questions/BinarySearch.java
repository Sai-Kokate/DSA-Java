import java.util.*;

public class BinarySearch {

  public static int binarySearch(int arr[], int key) { // TC = O(logn)
    int start = 0;
    int end = arr.length - 1;
    int mid = (end + start) / 2;

    while (start <= end) {

      if (arr[mid] == key) {
        return mid;
      } else {
        if (arr[mid] > key) {
          end = mid - 1;
          mid = (end + start) / 2;
        } else {
          start = mid + 1;
          mid = (end + start) / 2;
        }
      }
      // System.out.println(
      // "Inside while: " + "start: " + start + " end: " + end + " mid: " + mid + "
      // arr[mid]: " + arr[mid] + " key: " + key);
    }
    return -1;

  }

  public static void main(String[] args) {
    int arr[] = { 1, 6, 7, 8, 4, 2, 3, 9, 5 };
    int sortedArr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int key = 9;
    int res = binarySearch(sortedArr, key);
    if (res == -1) {
      System.out.println("No matching number found");
    } else {
      System.out.println("Matching number found at index: " + res);
    }
  }
}
