import java.util.*;

public class PairsInArray {
  public static void pairsInArrays(int numbers[]) {
    int pairs = 0;
    for (int i = 0; i < numbers.length; i++) {
      int current = numbers[i];
      for (int j = i + 1; j < numbers.length; j++) {
        System.out.print("(" + current + "," + numbers[j] + ")");
        pairs++;
      }
      System.out.println();
    }
    System.out.println("Number of pairs: " + pairs);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 6, 7, 8, 4, 2, 3, 9, 5 };
    pairsInArrays(arr);
  }
}
