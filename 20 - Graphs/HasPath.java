import java.util.*;

public class HasPath {
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

  public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
    if (src == dest) {
      return true;
    } // visit curr
    vis[src] = true;

    for (int i = 0; i < graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      int neighbour = e.dest;
      if (!vis[neighbour] && hasPath(graph, neighbour, dest, vis)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int V = 7;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V]; // currently each index hasnull

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>(); // creating empty arraylist at each vertex
    }

    // 0 vertex
    graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));

    // 1 vertex
    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 3, 1));

    // 2 vertex
    graph[2].add(new Edge(2, 0, 1));
    graph[2].add(new Edge(2, 4, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 1, 1));
    graph[3].add(new Edge(3, 4, 1));
    graph[3].add(new Edge(3, 5, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 2, 1));
    graph[4].add(new Edge(4, 3, 1));
    graph[4].add(new Edge(4, 5, 1));

    // 5 vertex
    graph[5].add(new Edge(5, 3, 1));
    graph[5].add(new Edge(5, 4, 1));
    graph[5].add(new Edge(5, 6, 1));

    // 6 vertex
    graph[6].add(new Edge(6, 5, 1));

    boolean vis[] = new boolean[V];
    System.out.println();
    System.out.println(hasPath(graph, 0, 5, vis));
  }
}
