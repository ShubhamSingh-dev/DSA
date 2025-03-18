public class DeleteNode {
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

  // Function to delete a node with the given value from the binary search tree
  public static Node delete(Node root, int val) {
    if (root == null) {
      return null;
    }

    // If the value to be deleted is greater than the root's data, recur for the right subtree
    if (root.data < val) {
      root.right = delete(root.right, val);
    }
    // If the value to be deleted is less than the root's data, recur for the left subtree
    else if (root.data > val) {
      root.left = delete(root.left, val);
    }
    // If the value matches the root's data, this is the node to be deleted
    else {
      // Case 1: Node has no children (leaf node)
      if (root.left == null && root.right == null) {
        return null;
      }
      // Case 2: Node has one child (right child only)
      if (root.left == null) {
        return root.right;
      }
      // Case 2: Node has one child (left child only)
      else if (root.right == null) {
        return root.left;
      }

      // Case 3: Node has two children
      // Find the inorder successor (smallest node in the right subtree)
      Node IS = findInorderSuccessor(root.right);
      // Replace the current node's data with the inorder successor's data
      root.data = IS.data;
      // Delete the inorder successor
      root.right = delete(root.right, IS.data);
    }

    return root;
  }

  // Function to find the inorder successor (smallest node in the right subtree)
  public static Node findInorderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  // Function to perform an inorder traversal of the binary search tree
  public static void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void main(String[] args) {
    // Array of values to be inserted into the binary search tree
    int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    Node root = null;

    // Insert each value into the binary search tree
    for (int i = 0; i < values.length; i++) {
      root = insert(root, values[i]);
    }

    // Perform an inorder traversal before deletion
    System.out.println("Inorder traversal before deletion:");
    inorder(root);
    System.out.println();

    // Delete a node with the given value
    root = delete(root, 5);

    // Perform an inorder traversal after deletion
    System.out.println("Inorder traversal after deletion:");
    inorder(root);
    System.out.println();
  }
}