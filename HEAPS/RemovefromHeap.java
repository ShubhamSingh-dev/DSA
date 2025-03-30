import java.util.*;

public class RemovefromHeap {

  static class Heap {
    ArrayList<Integer> arr; // ArrayList to store heap elements

    // Constructor to initialize the heap
    public Heap() {
      arr = new ArrayList<>(); // Initialize the ArrayList
    }

    // Function to add an element to the heap
    public void add(int data) { // TC: O(logn)
      // Step 1: Add the new element at the last index
      arr.add(data);

      int x = arr.size() - 1; // x is the child index
      int par = (x - 1) / 2; // par is the parent index

      // Step 2: Heapify upwards to maintain the max-heap property
      while ( arr.get(x) > arr.get(par)) { // by changin sign we can make it min heap
        // Swap child and parent if child is greater than parent
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par; // Update x to the parent index
        par = (x - 1) / 2; // Update par to the new parent index
      }
    }

    // Function to get the root element (highest priority) of the heap
    public int peek() { // TC: O(1)
      return arr.get(0); // Return the root element
    }

    // Function to heapify the subtree with the given index
    private void heapify(int i) { // TC: O(logn)
      int left = 2 * i + 1; // Left child index
      int right = 2 * i + 2; // Right child index
      int maxIdx = i; // Initialize maxIdx as the current index

      // Check if the left child is greater than the current node
      if (left < arr.size() && arr.get(maxIdx) < arr.get(left)) { // by changing sign we can make it min heap
        maxIdx = left; // Update maxIdx to the left child
      }

      // Check if the right child is greater than the current node
      if (right < arr.size() && arr.get(maxIdx) < arr.get(right)) { // by changing sign we can make it min heap
        maxIdx = right; // Update maxIdx to the right child
      }

      // If maxIdx is not the current index, swap and heapify recursively
      if (maxIdx != i) {
        int temp = arr.get(i);
        arr.set(i, arr.get(maxIdx));
        arr.set(maxIdx, temp);

        // Recursively heapify the affected subtree
        heapify(maxIdx);
      }
    }

    // Function to remove the root element from the heap
    public int remove() { // TC: O(logn)
      int data = arr.get(0); // Store the root element to return later

      // Step 1: Swap the first and last elements
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, temp);

      // Step 2: Remove the last element
      arr.remove(arr.size() - 1);

      // Step 3: Heapify the root element to maintain the heap property
      if (!arr.isEmpty()) {
        heapify(0);
      }

      return data; // Return the removed element
    }

    // Function to check if the heap is empty
    public boolean isEmpty() {
      return arr.size() == 0; // Return true if the heap is empty
    }
  }

  public static void main(String[] args) {
    Heap h = new Heap(); // Create a new heap
    h.add(3); // Add elements to the heap
    h.add(4);
    h.add(1);
    h.add(5);

    // Remove and print elements from the heap until it is empty
    while (!h.isEmpty()) {
      System.out.println(h.peek()); // Print the root element (highest priority)
      h.remove(); // Remove the root element
    }
  }
}