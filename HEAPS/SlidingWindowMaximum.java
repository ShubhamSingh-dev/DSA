import java.util.*;
public class SlidingWindowMaximum { // TC = O(nlogk)

  // Pair class to store both the value and its index in the array.
  // Implements Comparable so that pairs can be sorted in the priority queue.
  static class Pair implements Comparable<Pair> {
    int val; // The value from the array
    int idx; // The index of the value in the array

    // Constructor to initialize the Pair object with value and index
    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    // This method defines how two Pair objects are compared in the priority queue.
    // We want the largest value at the top, so we sort in descending order of value.
    @Override
    public int compareTo(Pair p2) {
      return p2.val - this.val; // Descending order
    }
  }

  public static void main(String[] args) {
    // Input array and window size
    int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3; // Sliding window size

    // Result array to store the maximum of each window
    int res[] = new int[arr.length - k + 1]; // There are n-k+1 windows

    // Priority queue (max-heap) to store pairs of value and index
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    // Add the first k elements to the priority queue
    for (int i = 0; i < k; i++) {
      pq.add(new Pair(arr[i], i));
    }

    // The maximum of the first window is at the top of the heap
    res[0] = pq.peek().val;

    // Process the rest of the array
    for (int i = k; i < arr.length; i++) {
      // Remove elements from the heap that are outside the current window
      while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
        pq.remove();
      }

      // Add the new element to the heap
      pq.add(new Pair(arr[i], i));

      // The maximum of the current window is at the top of the heap
      res[i - k + 1] = pq.peek().val;
    }

    // Print the result array (maximum of each sliding window)
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i] + " ");
    }
  }
}