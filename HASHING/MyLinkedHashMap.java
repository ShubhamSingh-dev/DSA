import java.util.*;

public class MyLinkedHashMap {
  public static void main (String args[]) {
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

    lhm.put("India", 100);
    lhm.put("USA", 200);
    lhm.put("UK", 300);
    lhm.put("Russia", 400);

    System.out.println(lhm);
  }
}