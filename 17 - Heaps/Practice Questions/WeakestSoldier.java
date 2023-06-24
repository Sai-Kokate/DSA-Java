import java.util.*;

public class WeakestSoldier {
  static class Soldier implements Comparable<Soldier> {
    int row;
    int sol;
    int civ;

    public Soldier(int row, int sol, int civ) {
      this.row = row;
      this.sol = sol;
      this.civ = civ;
    }

    @Override
    public int compareTo(Soldier s2) {
      if (s2.sol == this.sol) {
        return this.row - s2.row;
      } else {
        return this.sol - s2.sol;
      }
    }
  }

  public static void main(String[] args) {
    int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
    PriorityQueue<Soldier> pq = new PriorityQueue<>();
    int k = 2;
    for (int i = 0; i < army.length; i++) {
      int sum = 0;

      for (int j = 0; j < army[0].length; j++) {
        sum = army[i][j];
      }

      pq.add(new Soldier(i, sum, army[0].length - sum));
    }

    for (int i = 0; i < k; i++) {
      System.out.println("R" + pq.remove().row);
    }
  }
}
