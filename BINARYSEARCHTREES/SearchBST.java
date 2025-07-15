
public class SearchBST {
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

        if (root.data > val) {
          root.left = insert(root.left, val);
        } else {
          root.right = insert(root.right, val);
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

      public static Boolean search(Node root, int key) {
        // If the root is null, return null
        if (root == null) {
          return false;
        }
    
        // If the key is equal to the root's data, return the root
        if (root.data == key) {
          return true;
        }
    
        // If the key is less than the root's data, search in the left subtree
        if (root.data > key) {
          return search(root.left, key);
        }
    
        // If the key is greater than or equal to the root's data, search in the right subtree
        return search(root.right, key);
      }
    
      public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
          root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 3)) {
          System.out.println("Key found");
        } else {
          System.out.println("Key not found");
        }
      }  
    }
  
