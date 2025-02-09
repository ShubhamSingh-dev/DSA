// Class to calculate the height, count, and sum of nodes in a binary tree
public class HeightOfTree {

  // Static inner class representing a Node in the tree
  static class Node {
    int data;  // Value stored in the node
    Node left, right;  // Left and right child references

    // Constructor to initialize a node with a given value
    Node(int data) {
      this.data = data;
      this.left = null;  // Initially, left child is null
      this.right = null; // Initially, right child is null
    }
  }

  // Function to calculate the height of the binary tree
  public static int height(Node root) {
    // Base case: If the tree is empty (root is null), return 0
    if (root == null) {
      return 0;
    }

    // Recursively calculate the height of the left and right subtrees
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    // The height of the tree is the maximum of left and right subtree heights + 1 (for the root node)
    return Math.max(leftHeight, rightHeight) + 1;
  }

  // Function to count the total number of nodes in the binary tree
  public static int count(Node root) {
    // Base case: If the tree is empty (root is null), return 0
    if (root == null) {
      return 0;
    }

    // Recursively calculate the count of the left and right subtrees
    int leftCount = count(root.left);
    int rightCount = count(root.right);

    // The total count of nodes is the sum of left and right subtree nodes + 1 (for the root node)
    return leftCount + rightCount + 1;
  }

  // Function to calculate the sum of all node values in the binary tree
  public static int sum(Node root) {
    // Base case: If the tree is empty (root is null), return 0
    if (root == null) {
      return 0;
    }

    // Recursively calculate the sum of the left and right subtrees
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);

    // The total sum of the tree is the sum of left and right subtree values + root node value
    return leftSum + rightSum + root.data;
  }

  public static void main(String[] args) {
    
    // Constructing a sample binary tree:
    /*
            1
           / \
          2   3
         / \  / \
        4  5 6  7
    */
    Node root = new Node(1);      // Root node with value 1
    root.left = new Node(2);      // Left child of root (value 2)
    root.right = new Node(3);     // Right child of root (value 3)
    root.left.left = new Node(4); // Left child of node 2 (value 4)
    root.left.right = new Node(5);// Right child of node 2 (value 5)
    root.right.left = new Node(6);// Left child of node 3 (value 6)
    root.right.right = new Node(7);// Right child of node 3 (value 7)

    // Print the height of the binary tree
    System.out.println("Height of tree: " + height(root)); // Output: 3

    // Print the count of nodes in the binary tree
    System.out.println("Total number of nodes: " + count(root)); // Output: 7

    // Print the sum of all node values in the binary tree
    System.out.println("Sum of all node values: " + sum(root)); // Output: 28 (1+2+3+4+5+6+7)
  }
}
