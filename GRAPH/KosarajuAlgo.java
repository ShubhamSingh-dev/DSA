import java.util.*;
public class KosarajuAlgo {
  static class Edge {
    int src;
    int dest;
    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for(int i=0 ; i < graph.length; i++){
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 1));
    graph[3].add(new Edge(3, 4));
  }


  public static void TopologicalSort(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer> s) {
    visited[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!visited[e.dest]) {
        TopologicalSort(graph, e.dest, visited, s);
      }
    }

    s.push(curr);
  }

  public static void dfs(ArrayList<Edge>[] graph , int curr, boolean visited[]){ //O(V+E)
    //visit
    visited[curr] = true;
    System.out.print(curr + " ");
    
    for(int i = 0; i < graph[curr].size(); i++){
      Edge e = graph[curr].get(i);
      if(!visited[e.dest]){ //unvisited neighbour
        dfs(graph, e.dest, visited);
      }
    }
  }
 
  //TimeComplexity: O(V+E)
  public static void Kosaraju(ArrayList<Edge>[] graph , int V) {
    // step 1:
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[V];
    for(int i=0; i < V; i++){
      if(!visited[i]){
        TopologicalSort(graph, i, visited, stack);
      }
    }

    //Step 2;
  ArrayList<Edge> transpose[] = new ArrayList[V];
  for(int i=0; i < graph.length; i++){
    visited[i] = false;
    transpose[i] = new ArrayList<Edge>(); 
  }

  for(int i=0; i < V; i++){
    for(int j=0; j < graph[i].size(); j++){ //neighbours
      Edge e = graph[i].get(j); //edge
      transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
    }
  }

  //Step 3:
  while(!stack.isEmpty()){
    int curr = stack.pop();
    if(!visited[curr]){
      System.out.println("SCC Component: "); //new component
      dfs(transpose, curr, visited); //dfs on transpose graph
      System.out.println();
    }
  }
  }

  public static void main(String args[]) {
    int V = 5;

    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);

    Kosaraju(graph, V);
  }
}