import java.util.*;

public class NearestKCars {
  static class Point implements Comparable<Point> {
    int x;
    int y;
    int distSq;
    int idx;

    public Point(int x, int y, int distSq, int i) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.idx = i;
    }

    @Override
    public int compareTo(Point p2) {
      return this.distSq - p2.distSq;
    }

  }

  public static void main(String[] args) {
    int dist[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    int k = 2;

    PriorityQueue<Point> pq = new PriorityQueue<>();

    for (int i = 0; i < dist.length; i++) {
      int x = dist[i][0];
      int y = dist[i][1];
      int distSq = x * x + y * y;
      pq.add(new Point(x, y, distSq, i));
    }

    for (int i = 0; i < k; i++) {
      System.out.println("C" + pq.remove().idx);
    }
  }
}