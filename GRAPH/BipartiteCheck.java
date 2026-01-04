import java.util.*;

public class BipartiteCheck {

    // ---------- Edge Class ----------
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // ---------- Graph Creation ----------
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // =====================================================
    // 1️⃣ BFS COLORING APPROACH
    // =====================================================
    public static boolean isBipartiteBFS(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // -1 = uncolored

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // new component
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (Edge e : graph[curr]) {
                        if (color[e.dest] == -1) {
                            color[e.dest] = 1 - color[curr];
                            queue.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false; // conflict
                        }
                    }
                }
            }
        }
        return true;
    }

    // =====================================================
    // 2️⃣ CYCLE-BASED APPROACH
    // Acyclic -> true
    // Even cycle -> true
    // Odd cycle -> false
    // =====================================================
    public static boolean isBipartiteByCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] depth = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, -1, 0, visited, depth)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(
            ArrayList<Edge>[] graph,
            int curr,
            int parent,
            int currDepth,
            boolean[] visited,
            int[] depth) {

        visited[curr] = true;
        depth[curr] = currDepth;

        for (Edge e : graph[curr]) {
            int neighbor = e.dest;

            if (!visited[neighbor]) {
                if (!dfs(graph, neighbor, curr, currDepth + 1, visited, depth)) {
                    return false;
                }
            }
            // Back-edge found → cycle
            else if (neighbor != parent) {
                int cycleLength = Math.abs(depth[curr] - depth[neighbor]) + 1;

                // Odd cycle → NOT bipartite
                if (cycleLength % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // ---------- Main Method ----------
    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("BFS Coloring Approach: " + isBipartiteBFS(graph));
        System.out.println("Cycle-Based Approach : " + isBipartiteByCycle(graph));
    }
}
