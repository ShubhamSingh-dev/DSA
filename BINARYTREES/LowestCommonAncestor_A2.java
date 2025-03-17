import java.util.*;

public class LowestCommonAncestor_A2 { // TC = O(n), SC = O(n)
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

  // Function to find the lowest common ancestor of two nodes n1 and n2
  public static Node lca2(Node root, int n1, int n2) {
    // If root is null, return null
    if (root == null) {
      return null;
    }

    // If either n1 or n2 matches with root's data, return root
    if (root.data == n1 || root.data == n2) {
      return root;
    }

    // Recur for left and right subtrees
    Node leftLCA = lca2(root.left, n1, n2);
    Node rightLCA = lca2(root.right, n1, n2);

    // If both left and right subtrees return non-null, root is the LCA
    if (rightLCA == null) {
      return leftLCA;
    } 
    
    if (leftLCA == null) {
      return rightLCA;
    } 
    
    return root;
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
    Node lca = lca2(root, n1, n2);
    System.out.println("Lowest Common Ancestor: " + lca.data);
  }
}
