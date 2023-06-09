public class ArrayReverse {

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void reverseArray(int arr[]) {
    int n = arr.length;
    int start = 0, end = n - 1;
    int temp = 0;

    while (start < end) {
      temp = arr[end];
      arr[end] = arr[start];
      arr[start] = temp;

      start++;
      end--;
    }

    System.out.println("The reversed array: ");
    printArr(arr);

  }

  public static void main(String[] args) {
    int arr[] = { 1, 6, 7, 8, 4, 2, 3, 9, 5 };
    reverseArray(arr);
  }
}
