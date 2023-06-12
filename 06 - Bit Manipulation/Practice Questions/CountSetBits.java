public class CountSetBits {

  public static void countSetBits(int x) { // TC = O(logn)
    int n = x;
    int bitMask = 1;
    int count = 0;

    while (n > 0) {
      int check = n & bitMask;
      if (!(check == 0)) {
        count++;
      }
      n = n >> 1;
    }

    System.out.println("No. of set bits in " + x + " are: " + count);
  }

  public static void main(String[] args) {
    int num = 16;
    countSetBits(num);

  }
}