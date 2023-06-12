public class CheckPowerOfTwo {

  public static void isPowerOfTwo(int x) {
    int check = x & (x - 1);

    if (check == 0) {
      System.out.println("The number " + x + " is a power of two");
    } else {
      System.out.println("The number " + x + " is NOT a power of two");
    }
  }

  public static void main(String[] args) {

    int num = 9;
    isPowerOfTwo(num);

  }
}
