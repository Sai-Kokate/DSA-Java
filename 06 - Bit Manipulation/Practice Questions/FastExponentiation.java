import java.util.*;

public class FastExponentiation {

  public static void calculationPower(int x, int y) {
    int bitMask = 1;
    int ans = 1, n = x, p = y;
    while (p > 0) {
      int check = p & bitMask; // checking if the LSB is 0 or 1
      if (check != 0) {
        ans = ans * n;
      }
      n = n * n;
      p = p >> 1; // Right Shifting power
    }

    System.out.println(x + "^" + y + " = " + ans);

  }

  public static void main(String[] args) {
    int num = 2;
    int pow = 5;

    calculationPower(num, pow);
  }

}
