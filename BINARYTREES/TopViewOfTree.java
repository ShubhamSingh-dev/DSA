import java.util.*; 

// Class to find the top view of a binary tree
public class TopViewOfTree {   

    // Node class represents each node of the binary tree
    static class Node {     
        int data;  // Data stored in the node
        Node left, right;  // Left and right child references

        // Constructor to initialize a node with a given value
        Node(int data) {       
            this.data = data;       
            this.left = null;       
            this.right = null;     
        }   
    }    

    // Info class helps store a node along with its horizontal distance (hd)
    static class Info {     
        Node node;  // The node itself
        int hd;  // Horizontal distance from the root

        // Constructor to initialize Info with a node and its horizontal distance
        public Info(Node node, int hd) {       
            this.node = node;       
            this.hd = hd;     
        }   
    }    

    // Function to print the top view of a binary tree
    public static void topView(Node root) {     
        /**
         * Approach: Breadth-First Search (BFS) using a Queue
         * - We traverse the tree level by level.
         * - Each node has a "horizontal distance" (hd) from the root.
         * - We store the first node encountered at each unique horizontal distance.
         */

        // Edge case: If the tree is empty, there's nothing to print
        if (root == null) return;

        // Queue to perform level-order traversal (stores nodes with their horizontal distance)
        Queue<Info> q = new LinkedList<>();  

        // HashMap to store the first node at each unique horizontal distance
        HashMap<Integer, Node> map = new HashMap<>(); 

        // Variables to keep track of the leftmost and rightmost horizontal distances
        int min = 0, max = 0;  

        // Start with the root node at horizontal distance 0
        q.add(new Info(root, 0));  
        q.add(null); // Null is used as a level marker for BFS

        // BFS traversal using queue
        while (!q.isEmpty()) {       
            Info curr = q.remove();  // Get the front element from the queue
            
            // If we encounter a null, it means we've completed one level of traversal
            if (curr == null) {  
                if (q.isEmpty()) {  // If queue is empty, all levels are processed
                    break;         
                } else {           
                    q.add(null); // Add null as a marker for the next level
                }                      
            } else {          
                // If this horizontal distance (hd) is encountered for the first time, store the node
                if (!map.containsKey(curr.hd)) {   
                    map.put(curr.hd, curr.node);  // Store the first occurring node at this hd         
                }            

                // Process the left child (if it exists)
                if (curr.node.left != null) {           
                    q.add(new Info(curr.node.left, curr.hd - 1));  // Move left -> hd decreases by 1           
                    min = Math.min(min, curr.hd - 1); // Update min horizontal distance       
                }            

                // Process the right child (if it exists)
                if (curr.node.right != null) {           
                    q.add(new Info(curr.node.right, curr.hd + 1));  // Move right -> hd increases by 1           
                    max = Math.max(max, curr.hd + 1); // Update max horizontal distance      
                }       
            }     
        }     

        // Print the top view by iterating from min to max horizontal distance
        for (int i = min; i <= max; i++) {       
            System.out.print(map.get(i).data + " ");  // Print nodes from leftmost to rightmost
        }    
    }   

    public static void main(String[] args) {     
        /**
         * Constructing the binary tree:
         *        1
         *       / \
         *      2   3
         *     / \  / \
         *    4  5 6  7
         * 
         * Expected Output (Top View): 4 2 1 3 7
         */

        Node root = new Node(1);  // Root node     
        root.left = new Node(2);     
        root.right = new Node(3);     
        root.left.left = new Node(4);     
        root.left.right = new Node(5);       
        root.right.left = new Node(6);     
        root.right.right = new Node(7);      

        // Call the function to print the top view
        topView(root);   
    } 
}
