// For a given integer array of size N. You have to find all the occurrences
// (indices) of a given element (Key) and print them. Use a recursive function to solve this
// problem.

public class AllOccurence {

  public static void findKey(int num[], int i, int key, String str) {
    // base case
    if (i == num.length - 1) {
      System.out.println(str.substring(0, str.length() - 1));
      return;
    }

    //
    if (num[i] == key) {
      findKey(num, i + 1, key, str + i + ",");
    } else {
      findKey(num, i + 1, key, str);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 2, 2, 4, 5, 6, 4, 8, 4, 9, 4, 7 };
    int key = 4;

    String str = "";

    findKey(arr, 0, key, str);

  }
}
