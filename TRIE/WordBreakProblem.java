public class WordBreakProblem {
  static class Node {
    Node[] children = new Node[26];
    boolean eow = false;

    public Node() {
      for (int i = 0; i < 26; i++) {
        children[i] = null;
      }
    }
  } 

  public static Node root = new Node();

  public static void insert(String word) { //O(L) where L is the  length of the largest word

    Node curr = root;
    for(int level = 0 ; level < word.length(); level++) {
      int index = word.charAt(level) - 'a';
      if(curr.children[index] == null) {
        curr.children[index] = new Node();
      }
      curr = curr.children[index];
    }

    curr.eow = true;
  }

  public static boolean search(String key) { //O(L)

    Node curr = root;
    for(int level = 0; level < key.length(); level++) {
      int index = key.charAt(level) - 'a';
      if(curr.children[index] == null) {
        return false;
      }
      curr = curr.children[index];
    }
    return curr.eow;
  }

  public static boolean wordBreak(String key) {
    if(key.length() == 0) { //Base Case
      return true;
    }

    for(int i = 1; i <= key.length(); i++) {
      if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String arr[] = {"i" , "like" , "sam" ,"samsung" , "mobile" , "ice"};
    for(int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }

    String key = "ilikesamsung";
    System.out.println(wordBreak(key));
    
  }
}
