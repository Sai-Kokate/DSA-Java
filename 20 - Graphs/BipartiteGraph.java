import java.util.*;

public class BipartiteGraph {
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
    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    // 2 vertex
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    // 3 vertex
    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));

    // 4 vertex
    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));

  }

  public static boolean chechBipartite(ArrayList<Edge>[] graph) {
    Queue<Integer> q = new LinkedList<>();
    int col[] = new int[graph.length]; // 0 and 1

    for (int i = 0; i < col.length; i++) {
      col[i] = -1; // initalising with -1
    }

    for (int i = 0; i < graph.length; i++) {
      if (col[i] == -1) {// BFS
        col[i] = 0;
        q.add(i);
        while (!q.isEmpty()) {
          int curr = q.remove();

          for (int j = 0; j < graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);

            if (col[e.dest] == -1) {
              int color = col[curr] == 0 ? 1 : 0;
              col[e.dest] = color;
              q.add(e.dest);
            } else if (col[curr] == col[e.dest]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int V = 5;
    // array of arraylist
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    System.out.println();
    System.out.println(chechBipartite(graph));
  }
}
