package ClimbingStairs;

public class TabulationWay {

  //Time Complexity: O(n) using Tabulation method
  public static int countWaysTab(int n) {
    //Create of storage
    int dp[] = new int[n + 1];

    //intialization
    dp[0] = 1;

    //tablation loop
    for (int i = 1; i <= n; i++) {
      if(i == 1){
        dp[i] = dp[i - 1] + 0;
      } else {
        dp[i] = dp[i - 1] + dp[i - 2]; 
      }
    }

    return dp[n];
  }
  public static void main(String[] args) {
    int n = 5;
    System.out.println("Total ways = " + countWaysTab(n));
  }
}
