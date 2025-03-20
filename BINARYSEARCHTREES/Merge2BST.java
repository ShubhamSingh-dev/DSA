import java.util.*;
public class Merge2BST {
  static class Node {
    int data; // Data stored in the node
    Node left, right; // References to left and right child nodes

    // Constructor to initialize the node with data
    Node(int data) {
      this.data = data;
      left = right = null; // Initialize left and right children to null
    }
  }

  // Function to get the inorder traversal of a binary search tree
  public static void getInorder(Node root, ArrayList<Integer> arr) {
    if (root == null) {
      return;
    }

    // Recur for the left subtree
    getInorder(root.left, arr);
    // Add the current node's data to the inorder list
    arr.add(root.data);
    // Recur for the right subtree
    getInorder(root.right, arr);
  }

  // Function to create a balanced binary search tree from a sorted array
  public static Node createBST(ArrayList<Integer> arr, int start, int end) {
    // Base case: If start index exceeds end index, return null
    if (start > end) {
      return null;
    }

    // Find the middle element of the current array segment
    int mid = (start + end) / 2;

    // Create a new node with the middle element as its data
    Node root = new Node(arr.get(mid));

    // Recursively construct the left and right subtrees
    root.left = createBST(arr, start, mid - 1);
    root.right = createBST(arr, mid + 1, end);

    return root;
  }

  // Function to merge two binary search trees into a single balanced BST
  public static Node mergeBSTs(Node root1, Node root2) {
    // Step 1: Get the inorder traversal of the first BST
    ArrayList<Integer> arr1 = new ArrayList<>();
    getInorder(root1, arr1);

    // Step 2: Get the inorder traversal of the second BST
    ArrayList<Integer> arr2 = new ArrayList<>();
    getInorder(root2, arr2);

    // Step 3: Merge the two sorted inorder lists into a single sorted list
    int i = 0, j = 0;
    ArrayList<Integer> finalArr = new ArrayList<>();
    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) < arr2.get(j)) {
        finalArr.add(arr1.get(i));
        i++;
      } else {
        finalArr.add(arr2.get(j));
        j++;
      }
    }

    // Add remaining elements from arr1, if any
    while (i < arr1.size()) {
      finalArr.add(arr1.get(i));
      i++;
    }

    // Add remaining elements from arr2, if any
    while (j < arr2.size()) {
      finalArr.add(arr2.get(j));
      j++;
    }

    // Step 4: Convert the merged sorted array into a balanced BST
    return createBST(finalArr, 0, finalArr.size() - 1);
  }

  // Function to perform a preorder traversal of the binary search tree
  public static void preorder(Node root) {
    if (root == null) {
      return;
    }

    // Print the current node's data
    System.out.print(root.data + " ");
    // Recur for the left and right subtrees
    preorder(root.left);
    preorder(root.right);
  }

  public static void main(String[] args) {
    // Create the first binary search tree
    Node root1 = new Node(2);
    root1.left = new Node(1);
    root1.right = new Node(4);

    // Create the second binary search tree
    Node root2 = new Node(9);
    root2.left = new Node(3);
    root2.right = new Node(12);

    // Merge the two binary search trees into a single balanced BST
    Node root = mergeBSTs(root1, root2);

    // Perform a preorder traversal of the merged BST
    System.out.println("Preorder Traversal of the merged BST: ");
    preorder(root);

    // Time Complexity: O(n + m) --> Linear time complexity
  }
}