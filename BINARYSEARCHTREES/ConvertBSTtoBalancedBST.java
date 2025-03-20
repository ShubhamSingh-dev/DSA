import java.util.*;

public class ConvertBSTtoBalancedBST {
  // Node class to represent each node in the binary search tree
  static class Node {
    int data; // Data stored in the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    public Node(int data) {
      this.data = data;
      this.left = this.right = null; // Initialize left and right children to null
    }
  }

  // Function to perform a preorder traversal of the binary search tree
  public static void preorder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  // Function to get the inorder traversal of the binary search tree
  public static void getInorder(Node root, ArrayList<Integer> inorder) {
    if (root == null) {
      return;
    }

    // Recur for the left subtree
    getInorder(root.left, inorder);
    // Add the current node's data to the inorder list
    inorder.add(root.data);
    // Recur for the right subtree
    getInorder(root.right, inorder);
  }

  // Function to convert a sorted array into a balanced binary search tree
  public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
    if (start > end) {
      return null;
    }

    // Find the middle element of the current array segment
    int mid = (start + end) / 2;

    // Create a new node with the middle element as its data
    Node root = new Node(inorder.get(mid));

    // Recursively construct the left and right subtrees
    root.left = createBST(inorder, start, mid - 1);
    root.right = createBST(inorder, mid + 1, end);

    return root;
  }

  // Function to convert an unbalanced BST into a balanced BST
  public static Node balancedBST(Node root) {
    // Step 1: Get the inorder traversal of the BST
    ArrayList<Integer> inorder = new ArrayList<>();
    getInorder(root, inorder);

    // Step 2: Convert the sorted inorder list into a balanced BST
    return createBST(inorder, 0, inorder.size() - 1);
  }

  public static void main(String[] args) {
    // Create an unbalanced binary search tree
    Node root = new Node(8);
    root.left = new Node(6);
    root.left.left = new Node(5);
    root.left.left.left = new Node(3);

    root.right = new Node(10);
    root.right.right = new Node(11);
    root.right.right.right = new Node(12);

    // Convert the unbalanced BST into a balanced BST
    root = balancedBST(root);

    // Perform a preorder traversal of the balanced BST
    System.out.println("Preorder traversal of the balanced BST:");
    preorder(root);
  }
}