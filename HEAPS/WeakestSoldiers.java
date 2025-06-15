import java.util.*;

public class WeakestSoldiers {
  // Row class to store the number of soldiers and the row index
  // Implements Comparable to allow sorting in the priority queue
  static class Row implements Comparable<Row> {
    int soldiers; // Number of soldiers in the row
    int idx;      // Index of the row

    public Row(int soldiers, int idx) {
      this.soldiers = soldiers;
      this.idx = idx;
    }

    // Compare rows: first by number of soldiers (ascending), then by index (ascending)
    @Override
    public int compareTo(Row r2) {
      if (this.soldiers == r2.soldiers) {
        return this.idx - r2.idx; // If same number of soldiers, compare by row index
      }
      return this.soldiers - r2.soldiers; // Fewer soldiers means weaker row (higher priority)
    }
  }

  public static void main(String[] args) {
    // 2D array representing the army: 1 = soldier, 0 = civilian
    int army[][] = {
      {1, 0, 0, 0},
      {1, 1, 1, 1},
      {1, 0, 0, 0},
      {1, 0, 0, 0}
    };

    int k = 2; // Number of weakest rows to find

    // Min-heap to store rows based on number of soldiers and row index
    PriorityQueue<Row> pq = new PriorityQueue<>();

    // Count soldiers in each row and add to the priority queue
    for (int i = 0; i < army.length; i++) {
      int count = 0;
      for (int j = 0; j < army[0].length; j++) {
        if (army[i][j] == 1) {
          count++;
        }
      }
      pq.add(new Row(count, i));
    }

    // Print the indices of the k weakest rows
    System.out.println("Indices of the " + k + " weakest rows:");
    for (int i = 0; i < k; i++) {
      System.out.println("R" + pq.remove().idx);
    }
  }
}