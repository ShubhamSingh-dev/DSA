public class PrintInRange {
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

  // Function to print all nodes in the range [k1, k2] in a binary search tree
  public static void printInRange(Node root, int k1, int k2) {
    if (root == null) {
      return;
    }

    if(root.data >= k1 && root.data <= k2) {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
    }
    else if(root.data < k1) {
      printInRange(root.left, k1, k2);
    }
    else {
      printInRange(root.right, k1, k2);
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

  public static void main(String[] args) {
    // Array of values to be inserted into the binary search tree
    int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    Node root = null;

    // Insert each value into the binary search tree
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    // Define the range [k1, k2]
    int k1 = 5, k2 = 12;

    // Print all nodes in the range [k1, k2]
    System.out.println("Nodes in range [" + k1 + ", " + k2 + "]:");
    printInRange(root, k1, k2);
    System.out.println();
  }
}