import java.util.*;

public class LowestCommonAncestor_A1 { // TC = O(n), SC = O(n)
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

  // Function to find the path from root node to the given node n
  public static boolean getPath(Node root, int n, ArrayList<Node> path) {
    // If root is null, return false
    if (root == null) {
      return false;
    }

    // Add the current node to the path
    path.add(root);

    // If the current node is the target node, return true
    if (root.data == n) {
      return true;
    }

    // Recursively check if the target node is in the left or right subtree
    boolean foundLeft = getPath(root.left, n, path);
    boolean foundRight = getPath(root.right, n, path);

    // If the target node is found in either subtree, return true
    if (foundLeft || foundRight) {
      return true;
    }

    // If the target node is not found, remove the current node from the path and return false
    path.remove(path.size() - 1);
    return false;
  }

  // Function to find the lowest common ancestor of two nodes n1 and n2
  public static Node lowestCommonAncestor(Node root, int n1, int n2) {
    // Lists to store the paths from root to n1 and n2
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    // Get the paths from root to n1 and n2
    getPath(root, n1, path1);
    getPath(root, n2, path2);

    // Find the last common node in the paths
    int i = 0;
    for (; i < path1.size() && i < path2.size(); i++) {
      if (path1.get(i) != path2.get(i)) {
        break;
      }
    }

    // The last common node is the lowest common ancestor
    return path1.get(i - 1);
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

    // Nodes to find the lowest common ancestor for
    int n1 = 4;
    int n2 = 5;

    // Find and print the lowest common ancestor
    Node lca = lowestCommonAncestor(root, n1, n2);
    System.out.println("Lowest Common Ancestor: " + lca.data);
  }
}
