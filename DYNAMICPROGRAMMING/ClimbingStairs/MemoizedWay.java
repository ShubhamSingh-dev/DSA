package ClimbingStairs;
import java.util.Arrays;

public class MemoizedWay {
  
  // Time Complexity: O(n) Which is good and optimized
   public static int countWays(int n , int ways[]){ {
    if( n == 0 ){
      return 1;
    }
    if(n < 0){
      return 0;
    }

    if(ways[n] != -1){ //already calculated
      return ways[n];
    }

    ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
    return ways[n];
  }
}
  
  public static void main(String[] args) {
    int n = 5;

    int ways[] = new int[n + 1]; // ways[i] stores the value of countWays(i)
    Arrays.fill(ways, -1); //fills the array with -1 in all indices

    System.out.println("Total ways = " + countWays(n, ways));
  }
}
