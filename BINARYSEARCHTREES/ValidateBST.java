public class ValidateBST {
  // Node class to represent each node in the binary search tree
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

  // Function to insert a new value into the binary search tree
  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }

    if (val < root.data) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }

    return root;
  }

  // Function to validate if the binary search tree is valid
  public static boolean isValidBST(Node root ,Node min, Node max) {
    if (root == null) {
      return true;
    }

    if (min != null && root.data <= min.data) {
      return false;
    } 
    else if (max != null && root.data >= max.data) {
      return false;
    }

    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

  }

  public static void main(String[] args) {
    // Array of values to be inserted into the binary search tree
    int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    Node root = null;

    // Insert each value into the binary search tree
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    if(isValidBST(root, null, null)){
      System.out.println("The binary search tree is valid");
    }
    else{
      System.out.println("The binary search tree is not valid");
    }
  }
}