
import java.util.*;
public class InsertAndPeekInHeap {

  static class Heap {
    ArrayList<Integer> arr; // ArrayList to store heap elements

    public void add(int data) { //Tc: O(logn) 
      // Add at last idx
      arr.add(data);

      int x = arr.size() - 1; // x is the child index
      int par = (x - 1) / 2; // par is the parent index

      while (arr.get(x) > arr.get(par)) { 
        // Swap child and parent if child is greater than parent
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);
      }
    }

    public int peek() { //Tc: O(1)
      // Return the root element (highest priority) of the heap
      return arr.get(0);
    }
  }
  public static void main(String[] args) {

  }
}