import java.util.TreeSet;

public class treeSet {
  public static void main(String[] args) {
    TreeSet<String> ts = new TreeSet<>(); //creating treeset 

    ts.add("Mumbai");
    ts.add("Delhi");
    ts.add("Chennai");
    ts.add("Kolkata");
    ts.add("Pune");
    
    System.out.println(ts); //will be ordered Ascending 
  }
}
