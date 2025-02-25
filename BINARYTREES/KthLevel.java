public class KthLevel {
  // Define a static inner class to represent a node in the binary tree
  static class Node {
    int data; // Data stored in the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    Node(int data) {
      this.data = data;
      this.left = null; // Initialize left child to null
      this.right = null; // Initialize right child to null
    }

    // Method to print nodes at the k-th level of the binary tree
    public static void KthLevel(Node root, int level, int k) {
      // Base case: if the tree is empty, return
      if (root == null) {
        return;
      }
      // If the current level matches the k-th level, print the node's data
      if (level == k) {
        System.out.print(root.data + " ");
        return;
      }
      // Recursively traverse the left and right subtrees, incrementing the level
      KthLevel(root.left, level + 1, k);
      KthLevel(root.right, level + 1, k);
    }
  }

  // Main method to test the KthLevel method
  public static void main(String[] args) {
    // Create a sample binary tree
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    // Specify the level to print (1-indexed)
    int k = 2;

    // Call the KthLevel method to print nodes at the k-th level
    Node.KthLevel(root, 1, k);
  }
}