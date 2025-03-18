public class BuildBST {
  // Node class to represent each node in the binary search tree
  static class Node {
    int data; // Data stored in the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    Node(int data) {
      this.data = data;
    }
  }

  // Function to insert a new value into the binary search tree
  public static Node insert(Node root, int val) {
    // If the tree is empty, create a new node and return it
    if (root == null) {
      root = new Node(val);
      return root;
    }

    // If the value to be inserted is less than the root's data, insert in the left subtree
    if (root.data > val) {
      root.left = insert(root.left, val);
    } else {
      // If the value to be inserted is greater than or equal to the root's data, insert in the right subtree
      root.right = insert(root.right, val);
    }

    return root;
  } 

  // Function to perform an inorder traversal of the binary search tree
  public static void inorder(Node root) {
    // If the root is null, return
    if (root == null) {
      return;
    }

    // Recur for the left subtree
    inorder(root.left);
    // Print the current node's data
    System.out.print(root.data + " ");
    // Recur for the right subtree
    inorder(root.right);
  }

  public static void main(String[] args) {
    // Array of values to be inserted into the binary search tree
    int values[] = { 5, 1, 3, 4, 2, 7 };
    Node root = null;

    // Insert each value into the binary search tree
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    // Perform an inorder traversal of the binary search tree
    inorder(root);
    System.out.println();
  }  
}
