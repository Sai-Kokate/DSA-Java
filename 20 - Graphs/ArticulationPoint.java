import java.util.*;

public class ArticulationPoint {
  static class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>(); // creating empty arraylist at each vertex
    }

    // 0 vertex
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    // 1 vertex
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    // 2 vertex
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));

    graph[4].add(new Edge(4, 3));

  }

  public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], boolean vis[], int time,
      boolean ap[]) {
    vis[curr] = true;
    dt[curr] = low[curr] = ++time;
    int childern = 0;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i); // e.src -> e.dest
      int neigh = e.dest;
      // case 1
      if (neigh == par) {
        continue;
      } else if (!vis[neigh]) {
        dfs(graph, neigh, curr, dt, low, vis, time, ap);
        low[curr] = Math.min(low[curr], low[neigh]); // update low of curr
        if (par != -1 && dt[curr] <= low[neigh]) { // bridge condition
          ap[curr] = true;
        }
        childern++;
      } else {
        low[curr] = Math.min(low[curr], dt[neigh]);
      }
    }

    if (par == -1 && childern > 1) {
      ap[curr] = true;

    }
  }

  public static void getAP(ArrayList<Edge>[] graph, int V) {
    int dt[] = new int[V];
    int low[] = new int[V];
    boolean vis[] = new boolean[V];
    boolean ap[] = new boolean[V];
    int time = 0;

    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        dfs(graph, i, -1, dt, low, vis, time, ap);
      }
    }

    for (int i = 0; i < ap.length; i++) {
      if (ap[i]) {
        System.out.println("AP: " + i);
      }
    }

  }

  public static void main(String[] args) {
    int V = 5;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println();
    getAP(graph, V);
  }
}
