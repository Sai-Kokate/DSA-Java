import java.util.*;

public class CheckOddEven {

  public static void checkOddEven(int num) {
    int bitmask = 1;
    int check = num & bitmask;

    if (check == 0) {
      System.out.println("The number " + num + " is Even.");
    } else {
      System.out.println("The number " + num + " is Odd.");
    }
  }

  public static void main(String[] args) {
    int test = 8;
    checkOddEven(test);
  }

}
