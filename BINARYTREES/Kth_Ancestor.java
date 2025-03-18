public class Kth_Ancestor {
  // Node class to represent each node in the binary tree
  static class Node {
    int data; // Data stored in the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    Node(int data) {
      this.data = data;
      this.left = null; // Initialize left child to null
      this.right = null; // Initialize right child to null
    }
  }

  // Function to find the Kth ancestor of a given node n
  public static int KthAncestor(Node root, int n, int k) {
    // If root is null, return -1
    if (root == null) {
      return -1;
    }

    // If the current node is the target node, return 0
    if (root.data == n) {
      return 0;
    }

    // Recur for left and right subtrees to find the distance
    int leftDist = KthAncestor(root.left, n, k);
    int rightDist = KthAncestor(root.right, n, k);

    // If the target node is not found in both subtrees, return -1
    if (leftDist == -1 && rightDist == -1) {
      return -1;
    }

    // Find the maximum distance from the target node
    int max = Math.max(leftDist, rightDist);

    // If the distance is equal to k, print the current node as the Kth ancestor
    if (max + 1 == k) {
      System.out.println("Kth Ancestor: " + root.data);
    }

    // Return the distance incremented by 1
    return max + 1;
  }

  public static void main(String[] args) {
    // Create a sample binary tree
    /*
            1
           / \
          2   3
         / \ / \
        4  5 6  7
    */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    // Find the Kth ancestor of the node
    int k = 2;
    int n = 5;

    // Print the Kth ancestor
    KthAncestor(root, n, k);
  }
}
