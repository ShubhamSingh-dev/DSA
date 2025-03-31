import java.util.*;
public class NearbyCars {

  static class Point implements Comparable<Point> {
    int x;
    int y;
    int distSq;
    int idx;

    public Point(int x, int y , int distSq ,int idx) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.idx = idx; // Store the index of the point
    }

    @Override
    public int compareTo(Point p2) {
      return this.distSq - p2.distSq; // Compare based on distance squared
    }
  }

  public static void main(String[] args) {
    int pts [][] = {{3,3},{5,-1},{-2,4}}; // Input points
    int k = 2; // Number of nearest neighbors to find

    PriorityQueue<Point> pq = new PriorityQueue<>(); // Min-heap to store points based on distance
    for (int i = 0; i < pts.length; i++) {
      int x = pts[i][0]; // x-coordinate of the point
      int y = pts[i][1]; // y-coordinate of the point
      int distSq = x * x + y * y; // Calculate distance squared from origin

      pq.add(new Point(x, y, distSq, i)); // Add point to the priority queue
    }

    // nearest k points
    for(int i = 0; i < k; i++) {
      System.out.println("C" + pq.remove().idx);
    }
  }
}
