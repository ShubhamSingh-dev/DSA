import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
  static class Edge {
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;   
            this.wt = w;
        }
    }
  
    static void createGraph(ArrayList<Edge>[] graph) {
      for(int i=0; i < graph.length ; i++){
        graph[i] = new ArrayList<>();
      }

     graph[0].add(new Edge(0, 1, 10));
     graph[0].add(new Edge(0, 2, 15));
     graph[0].add(new Edge(0, 3, 30));

     graph[1].add(new Edge(1, 0, 10));
     graph[1].add(new Edge(1, 3, 40));

     graph[2].add(new Edge(2, 0, 15));
     graph[2].add(new Edge(2, 3, 50));

     graph[3].add(new Edge(3, 1, 40));
     graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
    int v;
    int cost;
    int parent;

    public Pair(int v, int cost, int parent) {
        this.v = v;
        this.cost = cost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.cost - p2.cost;
    }
}


   // Time complexity: O(E log E)
public static void prims(ArrayList<Edge>[] graph) {
    boolean[] visited = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.add(new Pair(0, 0, -1)); // start node
    int finalCost = 0;

    System.out.println("Edges in MST:");

    while (!pq.isEmpty()) {
        Pair curr = pq.remove();

        if (!visited[curr.v]) {
            visited[curr.v] = true;
            finalCost += curr.cost;

            // print edge (except for source)
            if (curr.parent != -1) {
                System.out.println(curr.parent + " - " + curr.v + "  weight: " + curr.cost);
            }

            for (Edge e : graph[curr.v]) {
                if (!visited[e.dest]) {
                    pq.add(new Pair(e.dest, e.wt, curr.v));
                }
            }
        }
    }

    System.out.println("Total MST cost: " + finalCost);
}

  
  public static void main(String[] args) {
   int V=4;

   @SuppressWarnings("unchecked")
   ArrayList<Edge>[] graph = new ArrayList[V];
   createGraph(graph);
   prims(graph); //getting MST
  }
}
