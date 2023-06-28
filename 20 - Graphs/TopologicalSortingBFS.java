import java.util.*;

public class TopologicalSortingBFS { // Kahn's Algorithm

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

  public static void calcIndegree(ArrayList<Edge>[] graph, int indeg[]) {
    for (int i = 0; i < indeg.length; i++) {
      indeg[i] = 0;
    }
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        indeg[e.dest]++;
      }
    }
  }

  public static void bfsTopologicalSort(ArrayList<Edge>[] graph) {
    Queue<Integer> q = new LinkedList<>();
    int indeg[] = new int[graph.length];
    calcIndegree(graph, indeg);

    for (int i = 0; i < indeg.length; i++) {
      if (indeg[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " ");

      for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        int neighbour = e.dest;
        indeg[neighbour]--;
        if (indeg[neighbour] == 0) {
          q.add(neighbour);
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 6;
    // array of arraylist
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println();
    bfsTopologicalSort(graph);
  }
}
