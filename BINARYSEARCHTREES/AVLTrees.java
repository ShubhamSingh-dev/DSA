public class AVLTrees {
  // Node class to represent each node in the AVL tree
  static class Node {
    int data, height; // Data stored in the node and height of the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    Node(int data) {
      this.data = data;
      this.height = 1; // Initialize height as 1 (leaf node)
      this.left = this.right = null; // Initialize left and right children to null
    }
  }

  public static Node root; // Root of the AVL tree

  // Function to get the height of a node
  public static int height(Node root) {
    if (root == null) 
      return 0; // Height of a null node is 0
    return root.height;
  }

  // Utility function to find the maximum of two integers
  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  // Function to perform a right rotation on a subtree rooted with y
  public static Node rightRotate(Node y) {
    Node x = y.left; // x becomes the new root
    Node T2 = x.right; // T2 is the subtree that will be moved

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights of the rotated nodes
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;

    return x; // Return the new root
  }

  // Function to perform a left rotation on a subtree rooted with x
  public static Node leftRotate(Node x) {
    Node y = x.right; // y becomes the new root
    Node T2 = y.left; // T2 is the subtree that will be moved

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights of the rotated nodes
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y; // Return the new root
  }

  // Function to perform a preorder traversal of the AVL tree
  public static void preorder(Node root) {
    if (root != null) {
      System.out.print(root.data + " "); // Print the current node's data
      preorder(root.left); // Recur for the left subtree
      preorder(root.right); // Recur for the right subtree
    }
  }

  // Function to get the balance factor of a node
  public static int getBalance(Node root) {
    if (root == null)
      return 0; // Balance factor of a null node is 0
    return height(root.left) - height(root.right); // Difference between left and right subtree heights
  }

  // Function to insert a new key into the AVL tree
  public static Node insert(Node root, int key) {
    // Step 1: Perform the normal BST insertion
    if (root == null) {
      return new Node(key); // Create a new node if the tree is empty
    }

    if (key < root.data) {
      root.left = insert(root.left, key); // Insert in the left subtree
    } else if (key > root.data) {
      root.right = insert(root.right, key); // Insert in the right subtree
    } else {
      return root; // Duplicate keys are not allowed in AVL trees
    }

    // Step 2: Update the height of the current node
    root.height = 1 + max(height(root.left), height(root.right));

    // Step 3: Get the balance factor to check if the node is unbalanced
    int bf = getBalance(root);

    // Step 4: Perform rotations to balance the tree

    // Left Left Case
    if (bf > 1 && key < root.left.data) {
      return rightRotate(root);
    }

    // Right Right Case
    if (bf < -1 && key > root.right.data) {
      return leftRotate(root);
    }

    // Left Right Case
    if (bf > 1 && key > root.left.data) {
      root.left = leftRotate(root.left); // Perform left rotation on the left child
      return rightRotate(root); // Perform right rotation on the current node
    }

    // Right Left Case
    if (bf < -1 && key < root.right.data) {
      root.right = rightRotate(root.right); // Perform right rotation on the right child
      return leftRotate(root); // Perform left rotation on the current node
    }

    return root; // Return the unchanged root if the tree is already balanced
  }

  public static void main(String[] args) {
    // Insert nodes into the AVL tree
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    // Perform a preorder traversal of the constructed AVL tree
    System.out.println("Preorder Traversal of constructed AVL tree is:");
    preorder(root);
  }
}