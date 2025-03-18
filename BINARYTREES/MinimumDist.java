public class MinimumDist {
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

  // Function to find the lowest common ancestor (LCA) of two nodes n1 and n2
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

  // Function to find the distance from the LCA to a given node n
  public static int lcaDist(Node root, int n) {
    // If root is null, return -1
    if (root == null) {
      return -1;
    }

    // If the current node is the target node, return 0
    if (root.data == n) {
      return 0;
    }

    // Recur for left and right subtrees to find the distance
    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    // If the target node is not found in both subtrees, return -1
    if (leftDist == -1 && rightDist == -1) {
      return -1;
    } else if (leftDist == -1) {
      return rightDist + 1;
    } else {
      return leftDist + 1;
    }
  }

  // Function to find the minimum distance between two nodes in a binary tree
  static int minDist(Node root, int n1, int n2) {
    // Find the lowest common ancestor (LCA) of n1 and n2
    Node lca = lca2(root, n1, n2);

    // Find the distance from LCA to n1 and n2
    int dist1 = lcaDist(lca, n1);
    int dist2 = lcaDist(lca, n2);

    // Return the sum of the distances
    return dist1 + dist2;
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

    // Nodes to find the minimum distance between
    int n1 = 4;
    int n2 = 7;

    // Find and print the minimum distance between the nodes
    System.out.println("Minimum distance between nodes = " + minDist(root, n1, n2));
  }
}
