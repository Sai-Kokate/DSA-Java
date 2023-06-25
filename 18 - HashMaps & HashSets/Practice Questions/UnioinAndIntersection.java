import java.util.*;

public class UnioinAndIntersection {
  public static void main(String[] args) {
    int arr1[] = { 7, 3, 9 };
    int arr2[] = { 6, 3, 9, 2, 9, 4 };

    HashSet<Integer> union = new HashSet<>();
    HashSet<Integer> is = new HashSet<>();

    for (int i = 0, j = 0; i < arr1.length || j < arr2.length; i++, j++) {
      if (i < arr1.length && j < arr2.length) {
        union.add(arr1[i]);
        union.add(arr2[j]);
      } else if (j >= arr2.length) {
        union.add(arr1[i]);
      } else if (i >= arr1.length) {
        union.add(arr2[j]);
      }
    }

    System.out.println("Unioin: " + union + " , Size: " + union.size());

    // intersection
    for (int i = 0; i < arr1.length; i++) {
      is.add(arr1[i]);
    }

    HashSet<Integer> hs = new HashSet<>();
    int count = 0;
    for (int i = 0; i < arr2.length; i++) {
      if (is.contains(arr2[i])) {
        count++;
        hs.add(arr2[i]);
        is.remove(arr2[i]);
      }
    }

    System.out.println("Intersection: " + hs + " , No. of elements in intersection: " + count);
  }
}
