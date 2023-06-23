import java.util.*;

public class ChocolaProblem {
  public static void main(String[] args) {
    int n = 4, m = 6;
    Integer costVert[] = { 2, 1, 3, 1, 4 }; // m -1 (cols - 1)
    Integer costHor[] = { 4, 1, 2 }; // n-1 (rows - 1)

    Arrays.sort(costHor, Collections.reverseOrder());
    Arrays.sort(costVert, Collections.reverseOrder());

    int h = 0, v = 0;
    int hp = 1, vp = 1;
    int cost = 0;

    while (h < costHor.length && v < costVert.length) {
      if (costVert[v] >= costHor[h]) {
        // vertical cut
        cost = cost + costVert[v] * hp;
        vp++;
        v++;
      } else {
        // horizontal cut
        cost = cost + costHor[h] * vp;
        hp++;
        h++;
      }
    }

    while (h < costHor.length) {
      // remaining horizontal cuts
      cost = cost + costHor[h] * vp;
      hp++;
      h++;
    }

    while (v < costVert.length) {
      // remaining vertical cuts
      cost = cost + costVert[v] * hp;
      vp++;
      v++;
    }

    System.out.println("Min cost to cut the bar: " + cost);
  }
}
