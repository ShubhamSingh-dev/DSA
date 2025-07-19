import java.util.HashMap;

public class ItineraryFromTickets {

  public static String getStart(HashMap<String, String> tickets) {
    HashMap<String , String> revMap = new HashMap<>();

    for(String key : tickets.keySet()) {
      revMap.put(tickets.get(key), key);
    }

    for(String key: tickets.keySet()) {
      if(!revMap.containsKey(key)) {
        return key; //Starting point
      }
    }

    return null;
    

  }
  public static void main(String[] args) {  //TC = O(n)
    HashMap<String, String> ticktes = new HashMap<>();
    ticktes.put("Chennai" ,"Bengaluru");
    ticktes.put("Mumbai" ,"Delhi");
    ticktes.put("Goa" ,"Chennai");
    ticktes.put("Delhi" ,"Goa");


    String start = getStart(ticktes);
    System.out.print( start);

    for(String key : ticktes.keySet()) {
      System.out.print(" -> " + ticktes.get(key));
      start = ticktes.get(key);
    }

  }
}
