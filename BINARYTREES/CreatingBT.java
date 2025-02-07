import java.util.*;
public class CreatingBT { // This is the main class that contains everything

  // A class to represent a single node in the binary tree
  static class Node {
    int data;  // Stores the value of the node
    Node left; // Pointer to the left child
    Node right; // Pointer to the right child

    // Constructor to initialize the node with a value and set children to null
    Node(int data) {
      this.data = data;  // Assign value to the node
      this.left = null;  // Initially, left child is null
      this.right = null; // Initially, right child is null
    }
  }

  // BinaryTree class contains methods for building and managing the binary tree
  static class BinaryTree {
    static int idx = -1; // A variable to track the position in the array

    /*
     * Recursive function to build a binary tree from an array representation
     * Uses Preorder Traversal: Root → Left → Right
     */
    public static Node buildTree(int nodes[]) {
      idx++; // Move to the next index in the array

      // Base Case: If the current value is -1, return null (means no node here)
      if (nodes[idx] == -1) {
        return null; // No node, return null
      }

      // Create a new node with the current value in the array
      Node newNode = new Node(nodes[idx]);

      // Recursively build the left subtree and attach it to the current node
      newNode.left = buildTree(nodes);

      // Recursively build the right subtree and attach it to the current node
      newNode.right = buildTree(nodes);

      // Return the fully built node
      return newNode;
    }

    // Function to print the tree using Preorder Traversal
    public static  void preorder (Node root) { //TC: O(N) 
      if (root == null) {
        return;
      } 
      
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
    }

    // Function to print the tree using Inorder Traversal
    public static void inorder(Node root) {
      if (root == null) {
        return;
      }

      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }

    // Function to print the tree using Postorder Traversal
    public static void postorder(Node root) {
      if (root == null) {
        return;
      }

      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
    }

    // Function to print the tree using Level Order Traversal
    public static void levelOrder(Node root) {
      if (root == null) {
        return;
      }

      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);

      while (!q.isEmpty()) {
       Node currNode = q.remove();
       if (currNode == null) {
         System.out.println();
         if (q.isEmpty()) {
           break;
         }
         q.add(null);
       } else {
         System.out.print(currNode.data + " ");
         if (currNode.left != null) {
           q.add(currNode.left);
         }
         if (currNode.right != null) {
           q.add(currNode.right);
         }
       }
      }
    }
  }

  public static void main(String[] args) {
    
    int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

    // Create an instance of BinaryTree
    BinaryTree tree = new BinaryTree();

    // Call the buildTree function to create the tree and store the root node
    Node root = tree.buildTree(nodes);

    // Print the root node's value to verify the tree is built correctly
    System.out.println("Root of the tree: " + root.data); // Expected Output: 1

    // Print the tree using Preorder Traversal
    tree.preorder(root);
    System.out.println("");

    // Print the tree using Inorder Traversal
    tree.inorder(root); 
    System.out.println("");

    // Print the tree using Postorder Traversal
    tree.postorder(root);
    System.out.println("");

    // Print the tree using Level Order Traversal
    tree.levelOrder(root);
  }
}
