
public class FirstOccurence {

  public static int findFirstOccurance(int num[], int i, int key) {
    // basecase
    if (i >= num.length) {
      return -1;
    }

    if (num[i] == key) {
      return i;
    }

    return findFirstOccurance(num, i + 1, key);
  }

  public static void main(String[] args) {
    int num[] = { 1, 1, 3, 5, 6, 8, 5, 9 };
    int key = 9;

    System.out.println(findFirstOccurance(num, 0, key));

  }

}
