public class SearchInRotatedArray {

  public static int search(int arr[], int target, int si, int ei) {
    int mid = si + (ei - si) / 2;
    // base case
    if (arr[mid] == target) {
      return mid;
    }

    // if mid on line 1
    if (arr[si] <= arr[mid]) {
      if (arr[si] <= target && target < arr[mid]) {
        return search(arr, target, si, mid - 1);
      } else {
        return search(arr, target, mid + 1, ei);
      }
    } else {
      if (arr[mid] < target && target <= arr[ei]) {
        return search(arr, target, mid + 1, ei);
      } else {
        return search(arr, target, si, mid - 1);
      }
    }

  }

  public static void main(String[] args) {
    int arr[] = { 6, 7, 8, 9, 0, 1, 2 };
    int key = 2; // op -> 6
    System.out.println(search(arr, key, 0, arr.length - 1));
  }
}
