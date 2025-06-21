import java.util.*;

public class Operations {
  public static void main(String[] args) {

    //create 
    HashMap<String, Integer> hm = new HashMap<>(); 
    
    //Insert
    hm.put("India", 100);
    hm.put("USA", 200);
    hm.put("UK", 300);
    hm.put("Russia", 400);
    //output
    // {USA=200, UK=300, India=100, Russia=400}
    System.out.println(hm);

    //Get -> O(1)
    int value = hm.get("India");
    System.out.println(value);

    //Contains Key -> O(1)
    System.out.println(hm.containsKey("India")); //true
    System.out.println(hm.containsKey("Germany")); //false

    //Contains Value -> O(n)
    System.out.println(hm.containsValue(100));  //true
    System.out.println(hm.containsValue(500));  //false
    
    //Remove -> O(1)
    System.out.println(hm.remove("Russia")); //deletes and also returns the value

    //Size -> O(1)
    System.out.println(hm.size());

    //isEmpty -> O(1)
    System.out.println(hm.isEmpty());

    //Clear -> O(1)
    hm.clear();



  }
}
