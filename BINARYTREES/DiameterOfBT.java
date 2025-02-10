public class DiameterOfBT {

  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // Function to calculate height of a tree
  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  // Approach 1: Brute Force Method
  // Time Complexity: O(n^2) due to repeated height calculations
  public static int diameter_1(Node root) { 
    if (root == null) {
      return 0;
    }

    // Compute diameter of left subtree
    int leftDiameter = diameter_1(root.left);
    // Compute height of left subtree
    int leftHeight = height(root.left);

    // Compute diameter of right subtree
    int rightDiameter = diameter_1(root.right);
    // Compute height of right subtree
    int rightHeight = height(root.right);

    // Compute diameter passing through the current node
    int selfDiameter = leftHeight + rightHeight + 1;

    // Return the maximum of all three values
    return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
  }

  // Approach 2: Optimized Approach using a helper class
  static class Info {
    int height;
    int diameter;

    public Info(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }

  // Optimized function to calculate diameter and height in a single traversal
  public static Info diameter_2(Node root) {
    if (root == null) {
      return new Info(0, 0);
    }
   
    // Get information (height & diameter) from left subtree
    Info leftInfo = diameter_2(root.left);
    
    // Get information (height & diameter) from right subtree
    Info rightInfo = diameter_2(root.right);

    // Compute diameter: maximum of left subtree diameter, right subtree diameter,
    // or path passing through root
    int diameter = Math.max(Math.max(leftInfo.diameter ,rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
    
    // Compute height: max height of left or right subtree + 1 (for current node)
    int height = Math.max(leftInfo.height, rightInfo.height) + 1;

    return new Info(height, diameter); // Return computed height and diameter
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("Diameter of the binary tree by approach 1 is: " + diameter_1(root));
    System.out.println("Diameter of the binary tree by approach 2 is: " + diameter_2(root).diameter);
  }
}
