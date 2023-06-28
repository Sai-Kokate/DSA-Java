import java.util.*;

public class DirectedCycleDetection {

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

    // 1 vertex
    // graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    // 2 vertex
    graph[2].add(new Edge(2, 3));

    // 3 vertex
    // graph[3].add(new Edge(3, 0));
  }

  public static boolean isCycle(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];

    for (int i = 0; i < stack.length; i++) {
      if (!vis[i]) {
        if (isCycleUtil(graph, vis, stack, i)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean vis[], boolean stack[], int curr) {
    vis[curr] = true;
    stack[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);

      if (stack[e.dest] == true) { // is neighbour is already present in the stack , its a cycle
        return true;
      }
      if (!vis[e.dest]) { // if neighbour not visited. visit the neighbour
        if (isCycleUtil(graph, vis, stack, e.dest)) { // if neighbour returns true for cycle
          return true; // cycle exists
        }
      }
    }
    stack[curr] = false; // backtrack
    return false;
  }

  public static void main(String[] args) {
    int V = 4;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println();
    System.out.println(isCycle(graph));
  }

}
