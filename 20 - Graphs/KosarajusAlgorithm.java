import java.util.*;

public class KosarajusAlgorithm {
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

    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 4));

  }

  public static void topSort(ArrayList<Edge>[] graph, boolean vis[], Stack<Integer> s, int curr) {
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topSort(graph, vis, s, e.dest);
      }
    }

    s.push(curr); // backtrack

  }

  public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
    // visit curr
    System.out.print(curr + " ");
    vis[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      int newCurr = e.dest;
      if (!vis[newCurr]) {
        dfs(graph, newCurr, vis);
      }
    }
  }

  public static void kosaraju(ArrayList<Edge>[] graph, int V) {
    // Step 1
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        topSort(graph, vis, s, i);
      }
    }

    // Step -2 - transpose graph
    ArrayList<Edge>[] transpose = new ArrayList[V];
    for (int i = 0; i < V; i++) {
      vis[i] = false;
      transpose[i] = new ArrayList<>(); // creating empty arraylist at each vertex
    }

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < graph[i].size(); j++) {

        Edge e = graph[i].get(j);
        transpose[e.dest].add(new Edge(e.dest, e.src));
      }
    }

    // step 3 - dfs on transpose graph using elements in stack
    while (!s.isEmpty()) {
      int curr = s.pop();
      if (!vis[curr]) {
        System.out.print("SCC->");
        dfs(transpose, curr, vis);
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    int V = 5;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);

    System.out.println();

    kosaraju(graph, V);
  }
}
