import java.util.*;

public class SubarraySumK {
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
    int k = 3;

    HashMap<Integer, Integer> hm = new HashMap<>();

    int sum = 0;
    int count = 0;

    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];
      hm.put(sum, j);
    }
  }
}
