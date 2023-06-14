public class LastOccurence {

  public static int findLastOccurance(int num[], int i, int key) {
    // basecase
    if (i >= num.length) {
      return -1;
    }

    int isFound = findLastOccurance(num, i + 1, key);

    if (isFound == -1 && num[i] == key) {
      return i;
    }

    return isFound;
  }

  public static void main(String[] args) {
    int num[] = { 1, 1, 3, 5, 6, 8, 5, 9 };
    int key = 5;

    System.out.println(findLastOccurance(num, 0, key));

  }

}
