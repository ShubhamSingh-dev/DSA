// Kahns algorithm 
import java.util.*;

public class TopologicalSort_BFS {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for(int i=0; i < graph.length ; i++){
        graph[i] = new ArrayList<>();
      }

      graph[2].add(new Edge( 2,  3));

      graph[3].add(new Edge( 3,  1));

      graph[4].add(new Edge( 4,  0));
      graph[4].add(new Edge( 4,  1));

      graph[5].add(new Edge( 5,  0));
      graph[5].add(new Edge( 5,  2));
      
  }

  public static void calIndegree(ArrayList<Edge>[] graph , int indegree[]) {
    for(int i=0; i < graph.length; i++) { //here i is vertex of graph
      for(int j=0; j < graph[i].size(); j++) {
       Edge e = graph[i].get(j);
       indegree[e.dest]++; 
      }
    }
  }
  public static void toposort(ArrayList<Edge>[] graph) {
    int indegree[] = new int[graph.length];
    calIndegree(graph, indegree);
    Queue<Integer> q = new LinkedList<>();

    for(int i = 0; i < graph.length; i++){
      if(indegree[i] == 0){
        q.add(i);
      }
    }

    //bfs
    while(!q.isEmpty()){
      int curr = q.remove();
      System.out.print(curr + " "); //Topological sort print

      for(int i=0; i < graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        indegree[e.dest]--;
        if(indegree[e.dest] == 0){
          q.add(e.dest);
        }
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int V = 6;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[V]; //currently null -> array empty
    createGraph(graph);
    
    toposort(graph);
  }
}