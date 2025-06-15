import java.util.*;

public class ConnectNRopes {
  public static void main(String args[]) {
    // Array representing the lengths of the ropes
    int ropes[] = {2, 3, 3, 4, 6};

    // PriorityQueue (Min-Heap) to always get the smallest ropes first
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // Add all rope lengths to the priority queue
    for (int i = 0; i < ropes.length; i++) {
      pq.add(ropes[i]);
    }

    int cost = 0; // Variable to store the total cost

    // Keep connecting ropes until only one rope is left
    while (pq.size() > 1) {
      // Remove the two smallest ropes from the heap
      int min1 = pq.remove();
      int min2 = pq.remove();
      // Connect them (sum their lengths)
      int sum = min1 + min2;
      // Add the cost of this connection to the total cost
      cost += sum;
      // Add the new rope (result of connection) back to the heap
      pq.add(sum);
    }

    // Print the total minimum cost to connect all ropes
    System.out.println("Cost to connect ropes: " + cost);
  }
}