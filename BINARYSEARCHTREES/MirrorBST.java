public class MirrorBST {
  static class Node {
    int data;
    Node left, right;
    Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  public static Node createMirror(Node root) { // TC : O(N)
    if(root == null) {
      return null;
    }

    Node leftMirror = createMirror(root.left);
    Node rightMirror = createMirror(root.right);

    root.left = rightMirror;
    root.right = leftMirror;

    return root;
  }

  public static void preOrder(Node root) {
   if(root == null) {
     return;
   }

   System.out.print(root.data + " ");
   preOrder(root.left);
   preOrder(root.right);
  }
  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(5);
    root.right = new Node(10);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.left.left.left = new Node(11);

    System.out.println("Original Tree");
    preOrder(root);
    System.out.println();

    Node mirrorRoot = createMirror(root);
    System.out.println("Mirror Tree");
    preOrder(mirrorRoot);
  }
}
