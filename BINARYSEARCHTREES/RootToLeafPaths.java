import java.util.ArrayList;

public class RootToLeafPaths {
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

  public static void printPath(ArrayList<Integer> path) {
    for (int i = 0; i < path.size(); i++) {
      System.out.print(path.get(i) + "->");
    }
    System.out.println("null");
  }

  // Function to print all root-to-leaf paths in a binary search tree
  public static void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }

    // Add the current node's data to the path
    path.add(root.data);

    // If the current node is a leaf node, print the path
    if (root.left == null && root.right == null) {
      printPath(path);
    }

    // Recursively print the root-to-leaf paths in the left and right subtrees
    printRootToLeafPaths(root.left, path);
    printRootToLeafPaths(root.right, path);

    // Remove the current node's data from the path
    path.remove(path.size() - 1);
  }

  public static void main(String[] args) {
    // Array of values to be inserted into the binary search tree
    int values[] = {8, 5, 3, 6, 10, 11, 14};
    Node root = null;

    // Insert each value into the binary search tree
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    printRootToLeafPaths(root, new ArrayList<Integer>());
  }
}