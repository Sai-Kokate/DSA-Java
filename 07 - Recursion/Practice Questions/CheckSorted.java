public class CheckSorted {

  public static boolean isSorted(int num[], int i) {
    // base case
    if (i >= num.length - 1) {
      return true;
    }

    if (num[i] > num[i + 1]) {
      return false;
    }

    boolean ans = isSorted(num, (i + 1));
    return ans;
  }

  public static void main(String[] args) {
    int num[] = { 1, 1, 3, 5, 6, 8, 9 };
    int x[] = { 1, 9, 5 };

    System.out.println(isSorted(x, 0));
    System.out.println(isSorted(num, 0));

  }
}
