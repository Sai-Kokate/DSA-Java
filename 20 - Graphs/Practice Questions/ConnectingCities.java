import java.util.*;

public class ConnectingCities {
  static class Edge implements Comparable<Edge> {
    int dest;
    int cost;

    public Edge(int d, int c) {
      this.dest = d;
      this.cost = c;
    }

    @Override
    public int compareTo(Edge e2) {
      return this.cost - e2.cost;
    }
  }

  public static int minCost(int cities[][]) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[cities.length];

    int finCost = 0;

    pq.add(new Edge(0, 0));

    while (!pq.isEmpty()) {
      Edge curr = pq.remove();
      if (!vis[curr.dest]) {
        vis[curr.dest] = true;
        finCost += curr.cost;
        for (int j = 0; j < cities[curr.dest].length; j++) {
          if (cities[curr.dest][j] != 0) {
            pq.add(new Edge(j, cities[curr.dest][j]));
          }
        }
      }
    }

    return finCost;
  }

  public static void main(String[] args) {
    int cities[][] = { { 0, 1, 2, 3, 4 },
        { 1, 0, 5, 0, 7 },
        { 2, 5, 0, 6, 0 },
        { 3, 0, 6, 0, 0 },
        { 4, 7, 0, 0, 0 } };

    System.out.println("Min Cost of connecting cities: " + minCost(cities));
  }
}
