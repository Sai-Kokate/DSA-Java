import java.util.*;

public class AllPaths {
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
    graph[0].add(new Edge(0, 3));

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

  // TC = O(V^V) - exponential
  public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
    if (src == dest) {
      System.out.println(path + dest);
      return;
    }

    for (int i = 0; i < graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      printAllPaths(graph, e.dest, dest, path + src);
    }
  }

  public static void main(String[] args) {
    int V = 6;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println();

    int src = 5, dest = 1;
    printAllPaths(graph, src, dest, "");
  }

}
