import java.util.TreeMap;

public class TreeMaps {
  public static void main(String[] args) {
    TreeMap<String, Integer> tm = new TreeMap<>(); // TreeMap is a sorted map
    tm.put("India", 100);
    tm.put("USA", 200);
    tm.put("UK", 300);
    tm.put("Russia", 400);
    tm.put("america", 500);
    tm.put("zimbabwe", 600);
    // the sorting happens in lexicographical order
    // that is a-z or A-Z capital letters are prioritized

    System.out.println(tm); //sorted in alphabetical order
  }
}
