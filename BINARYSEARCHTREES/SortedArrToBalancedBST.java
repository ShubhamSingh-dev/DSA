public class SortedArrToBalancedBST {
  static class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

    // Function to convert a sorted array into a balanced binary search tree
    public static Node sortedArrayToBST(int arr[], int start, int end) {
      // Base case: If start index exceeds end index, return null
      if (start > end) {
        return null;
      }
  
      // Find the middle element of the current array segment
      int mid = (start + end) / 2;
  
      // Create a new node with the middle element as its data
      Node root = new Node(arr[mid]);
  
      // Recursively construct the left subtree using the left half of the array
      root.left = sortedArrayToBST(arr, start, mid - 1);
  
      // Recursively construct the right subtree using the right half of the array
      root.right = sortedArrayToBST(arr, mid + 1, end);
  
      // Return the root of the constructed subtree
      return root;
    }

  public static void main(String[] args) {
    int arr[] = {3,5,6,8,10,11,12};

    Node root = sortedArrayToBST(arr, 0, arr.length - 1);
    preorder(root);
  }
}