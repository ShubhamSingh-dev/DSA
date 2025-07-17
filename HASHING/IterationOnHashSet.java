import java.util.*;
public class IterationOnHashSet {
  public static void main(String[] args) {
   HashSet<String> cities = new HashSet<>(); //creating hashset 

   cities.add("Mumbai");
   cities.add("Delhi");
   cities.add("Chennai");
   cities.add("Kolkata");
   cities.add("Pune");

   // Iterating over HashSet using Iterator
   Iterator<String> it = cities.iterator();
   while (it.hasNext()) {
     String city = it.next();
     System.out.println(city); //will be unordered
   }

   // Iterating over HashSet using enhanced for loop
   for(String city : cities) {
     System.out.println(city); //will be unordered
   }
  } 
} 
