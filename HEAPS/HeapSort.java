public class HeapSort {

  // Function to maintain the max-heap property for a subtree rooted at index i
  public static void heapify(int arr[], int i, int size) {
    int left = 2 * i + 1; // Index of the left child
    int right = 2 * i + 2; // Index of the right child
    int maxIdx = i; // Initialize maxIdx as the current node

    // Check if the left child is larger than the current node
    if (left < size && arr[left] > arr[maxIdx]) {
      maxIdx = left; // Update maxIdx to the left child
    }

    // Check if the right child is larger than the current node
    if (right < size && arr[right] > arr[maxIdx]) {
      maxIdx = right; // Update maxIdx to the right child
    }

    // If maxIdx is not the current node, swap and heapify recursively
    if (maxIdx != i) {
      // Swap the current node with the largest child
      int temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;

      // Recursively heapify the affected subtree
      heapify(arr, maxIdx, size);
    }
  }

  // Function to perform heap sort on an array
  public static void heapSort(int arr[]) { // Tc = O(nlogn)
    // Step 1: Build a max-heap from the input array
    int n = arr.length;
    // Start from the last non-leaf node and heapify each node
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, i, n);
    }

    // Step 2: Extract elements from the heap one by one
    for (int i = n - 1; i > 0; i--) {
      // Swap the root (largest element) with the last element in the heap
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // Heapify the reduced heap to maintain the max-heap property
      heapify(arr, 0, i);
    }
  }

  public static void main(String[] args) {
    // Input array to be sorted
    int arr[] = {1, 2, 4, 5, 3};

    // Perform heap sort on the array
    heapSort(arr);

    // Print the sorted array
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    // Output: 1 2 3 4 5
  }
}