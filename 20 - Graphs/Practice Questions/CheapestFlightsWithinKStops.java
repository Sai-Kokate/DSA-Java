import java.util.*;

public class CheapestFlightsWithinKStops {
  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  static class Info {
    int vertex;
    int cost;
    int stops;

    public Info(int v, int c, int s) {
      this.vertex = v;
      this.cost = c;
      this.stops = s;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph, int flights[][]) {
    // initialize eacch vertex with empty arraylist
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < flights.length; i++) {
      graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
    }
  }

  public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
    Queue<Info> q = new LinkedList<>();
    int dist[] = new int[graph.length];
    int minCost = 0;
    for (int i = 0; i < dist.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    q.add(new Info(src, 0, 0));

    while (!q.isEmpty()) {
      Info curr = q.remove();
      int currCost = curr.cost;
      int currVer = curr.vertex;
      int currStops = curr.stops;

      dist[currVer] = currCost;

      if (currStops > k) {
        break;
      }

      for (int i = 0; i < graph[currVer].size(); i++) {
        Edge e = graph[currVer].get(i);
        int u = e.src, v = e.dest, wt = e.wt;
        // if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
        if (currCost + wt < dist[v]) { // using currCost instead of dist[u] , as we need the cost of our route and
                                       // not// the min cost

          // dist[v] = dist[u] + wt;
          dist[v] = currCost + wt;
          q.add(new Info(v, wt, currStops + 1));
        }
      }
    }

    if (dist[dest] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return dist[dest];
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
    int src = 0, dest = 3, k = 1;
    ArrayList<Edge>[] graph = new ArrayList[n];
    createGraph(graph, flights);
    System.out.println();
    System.out.println(cheapestFlight(graph, src, dest, k));
  }
}