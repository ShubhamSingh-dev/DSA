public class PrefixProblem {
  static class Node {
    Node[] children = new Node[26];
    boolean eow = false;
    int freq;

    public Node() {
      for (int i = 0; i < 26; i++) {
        children[i] = null;
      }
      freq = 1;
    }
  }

  public static Node root = new Node();

  public static void insert(String word) { //O(L) where L is the  length of the largest word

    Node curr = root;
    for(int level = 0 ; level < word.length(); level++) {
      int index = word.charAt(level) - 'a';
      if(curr.children[index] == null) {
        curr.children[index] = new Node();
      } else {
        curr.children[index].freq++;
      }
      curr = curr.children[index];
    }

    curr.eow = true;
  }

  public static void findPrefix(Node root , String ans) { //TC=O(L)
    if (root == null) {
      return;
    }

    if (root.freq == 1) {
      System.out.println(ans);
      return;
    }

    for(int i = 0; i < root.children.length; i++) {
      if (root.children[i] != null ) {
        findPrefix(root.children[i], ans + (char)(i + 'a'));
      }
    }
  }

  public static void main(String[] args) {
    String arr[] = {"zebra", "dog", "duck", "dove"};
    for (String word : arr) {
      insert(word);
    }

    root.freq = -1;
    findPrefix(root, "");
  }
}