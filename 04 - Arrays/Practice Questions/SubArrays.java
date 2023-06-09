public class SubArrays {
  public static void printSubArrays(int numbers[]) { // TC = O(n^3)
    int n = numbers.length;
    int arrays = 0;
    int current;
    int end;

    for (int i = 0; i < n; i++) {
      current = i;

      for (int j = current; j < n; j++) {
        end = j;
        System.out.print("[ ");
        for (int k = current; k <= end; k++) {
          System.out.print(numbers[k] + " ");
        }
        System.out.print("], ");
        arrays++;

      }
      System.out.println();
    }
    System.out.println("Total Number of Sub-Arrays: " + arrays);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 6, 7, 8, 4, 2, 3, 9, 5 };
    printSubArrays(arr);
  }
}
