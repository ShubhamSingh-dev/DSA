public class SubTree {
  // Node class representing a single node in a binary tree
  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // Function to check if two trees are identical
  // It returns true if both trees have the same structure and node values
  public static boolean isIdentical(Node node, Node subRoot) {
    // If both nodes are null, they are identical
    if (node == null && subRoot == null) {
      return true;
    } 
    // If either node is null or values don't match, trees are not identical
    else if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    } 

    // Recursively check if left and right subtrees are identical
    if (!isIdentical(node.left, subRoot.left)) {
      return false;
    }
    if (!isIdentical(node.right, subRoot.right)) {
      return false;
    }

    return true; // Both subtrees are identical
  }

  // Function to check if subRoot is a subtree of root
  public static boolean isSubtree(Node root, Node subRoot) {
    // If root is null, then subRoot cannot be a subtree
    if (root == null) {
      return false;
    }
    
    // If current root's data matches subRoot's data, check if they are identical
    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }  
    }

    // Recursively check if subRoot is a subtree of either left or right subtree of root
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
  
  public static void main(String[] args) {
      // Constructing a sample binary tree:
    /*
            1
           / \
          2   3
         / \  / \
        4  5 6   7
    */
    Node root = new Node(1);    
    root.left = new Node(2);   
    root.right = new Node(3);     
    root.left.left = new Node(4); 
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    // Constructing a sample subtree:
    Node subRoot = new Node(2);   // Subtree root node with value 2
    subRoot.left = new Node(4);   // Left child of subtree root (value 4)
    subRoot.right = new Node(5);  // Right child of subtree root (value 5)

    System.out.println(isSubtree(root, subRoot)); // Output: true
  }
}
