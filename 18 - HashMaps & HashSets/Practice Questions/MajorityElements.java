import java.util.*;

public class MajorityElements {

  public static void main(String[] args) {
    int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 5, 5 };
    int check = arr.length / (3);
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (!hm.containsKey(arr[i])) {
        hm.put(arr[i], 1);
      } else {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      }
    }

    Set<Integer> keys = hm.keySet();
    for (int k : keys) {
      if (hm.get(k) >= check) {
        System.out.print("Majority Element: " + k);
        System.out.println();
      }

    }
  }
}