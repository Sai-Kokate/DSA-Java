public class OperationsOnBits {

  public static void addOne(int x) {
    int n = -~x;
    System.out.println(x + " + " + 1 + " is " + n);
  }

  public static void getBit(int x, int i) {
    int bitMask = 1 << i;
    int n = x;
    int check = n & bitMask;
    if (check == 0) {
      System.out.println("The " + i + "th bit of " + x + " is: 0");
    } else {
      System.out.println("The " + i + "th bit of " + x + " is: 1");
    }
  }

  public static void setBit(int x, int i) {
    int bitMask = 1 << i;
    int n = x;
    n = n | bitMask;

    System.out.println("The number before setting bit at index " + i + " : " + x);
    System.out.println("The number after setting bit at index " + i + " : " + n);
  }

  public static void clearBit(int x, int i) {
    int bitMask = ~(1 << i);
    int n = x;
    n = n & bitMask;
    System.out.println("The number before clearing bit at index " + i + " : " + x);
    System.out.println("The number after clearing bit at index " + i + " : " + n);
  }

  public static void clearLastiBits(int x, int i) {
    int bitMask = (~0) << (i + 1);
    int n = x;
    n = n & bitMask;
    System.out.println("The number before clearing last " + (i + 1) + " bits: " + x);
    System.out.println("The number after clearing last " + (i + 1) + " bits: " + n);
  }

  public static void clearRangeOfBits(int x, int i, int j) {
    int a = (~0) << (i + 1);
    int b = (2 << j) - 1; // (2^j -1)
    int bitMask = a | b;
    int n = x;
    n = n & bitMask;
    System.out.println("The number before clearing bits between index " + i + " and " + j + " : " + x);
    System.out.println("The number after clearing bits: " + n);
  }

  public static void main(String[] args) {
    int num = 31;
    int index = 3;
    int j = 1;
    addOne(num);
    getBit(num, index);
    setBit(num, index);
    clearBit(num, index);
    clearLastiBits(num, index);
    clearRangeOfBits(num, index, j);

  }
}