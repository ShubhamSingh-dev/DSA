import java.util.*;
public class IterationInHashMap {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    map.put("d", 4);

    //Iterate
    //to get a set of pairs we use hm.entryset()
    Set<String> keys = map.keySet();
    System.out.println("Keys: " + keys);

    //foreach loop to iterate
    //we iterate on keys
    for (String key : keys) {
      System.out.println(key + ": " + map.get(key));
    }

  }
}
