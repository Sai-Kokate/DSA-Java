import java.util.*;

public class TopologicalSorting {
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

    // 2 vertex
    graph[2].add(new Edge(2, 3));

    // 3 vertex
    graph[3].add(new Edge(3, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    // 5 vertex
    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  public static void topologicalSort(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < graph.length; i++) {
      if (!vis[i]) {
        topSortUtil(graph, vis, s, i);
      }
    }

    // printing topologically sorted graph
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topSortUtil(ArrayList<Edge>[] graph, boolean vis[], Stack<Integer> s, int curr) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topSortUtil(graph, vis, s, e.dest);
      }
    }

    s.push(curr); // backtrack

  }

  public static void main(String[] args) {
    int V = 6;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println();
    topologicalSort(graph);
  }
}
