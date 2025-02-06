import java.util.*;
public class IndianCoin {
  public static void main(String[] args) {
      // Array of available coin denominations
      Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

      // Sort the coins in descending order to use the largest denominations first
      Arrays.sort(coins, Comparator.reverseOrder());

      // Initialize the count of coins used
      int countOfCoins = 0;
      // Amount to be changed
      int amount = 590;
      // List to store the coins used to make the amount
      ArrayList<Integer> ans = new ArrayList<>();

      // Iterate through the sorted coins
      for (int i = 0; i < coins.length; i++) {
          // Check if the current coin can be used to make the remaining amount
          if (coins[i] <= amount) {
              // Use the current coin as many times as possible
              while (coins[i] <= amount) {
                  // Increment the count of coins used
                  countOfCoins++;
                  // Add the current coin to the list of coins used
                  ans.add(coins[i]);
                  // Decrease the remaining amount by the value of the current coin
                  amount -= coins[i];
              }
          }
      }

      // Print the total number of coins used
      System.out.println("Total (min) coins required: " + countOfCoins);

      // Print the coins used to make the amount
      for (int i = 0; i < ans.size(); i++) {
          System.out.print(ans.get(i) + " ");
      }
      System.out.println();
  }
}