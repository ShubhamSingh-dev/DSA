public class SizeOfLargestBST {
    static class Node {
      int data;
      Node left, right;
  
      Node(int data) {
        this.data = data;
        left = right = null;
      }
    }
  
    static class Info {
      boolean isBST; // Indicates whether the subtree is a valid BST
      int size; // Size of the subtree (number of nodes)
      int min; // Minimum value in the subtree
      int max; // Maximum value in the subtree
  
      // Constructor to initialize the Info object
      public Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST; // Set whether the subtree is a BST
        this.size = size; // Set the size of the subtree
        this.min = min; // Set the minimum value in the subtree
        this.max = max; // Set the maximum value in the subtree
      }
    }
  
    public static int maxBST = 0; // Global variable to store the size of the largest BST
  
    // Function to find the size of the largest BST in a binary tree
    public static Info largestBST(Node root) {
      // Base case: If the root is null, return an Info object for an empty tree
      if (root == null) {
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
      }
  
      // Recursively find information about the left and right subtrees
      Info leftInfo = largestBST(root.left);
      Info rightInfo = largestBST(root.right);
  
      // Calculate the size of the current subtree
      int size = 1 + leftInfo.size + rightInfo.size;
  
      // Calculate the minimum and maximum values in the current subtree
      int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
      int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
  
      // If the current node violates the BST property, return false for isBST
      if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
        return new Info(false, size, min, max);
      }
  
      // If both left and right subtrees are BSTs, and the current node satisfies the BST property
      if (leftInfo.isBST && rightInfo.isBST) {
        // Update the global maxBST variable with the size of the current BST
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max); // Return Info for a valid BST
      }
  
      // If the current subtree is not a BST, return false for isBST
      return new Info(false, size, min, max);
    }
  
    public static void main(String[] args) {
      Node root = new Node(50);

        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);

        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // Expected answer should be 5

        Info info = largestBST(root);
        System.out.println("Largest BST size is " + maxBST);
    }
  }