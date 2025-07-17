import java.util.*;

public class HashSetLearn {
  public static void main(String[] args) {
    HashSet<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(4);
    set.add(2);
    set.add(1);
    
    System.out.println(set);

    set.remove(1);
    
    if(set.contains(2)) System.out.println("2 is present");

    if(set.contains(3)) System.out.println("3 is present");
  }
}