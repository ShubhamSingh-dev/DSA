import java.util.*;

public class FractionalKnapsack {
  public static void main(String[] args) {
    // Values (profits) and corresponding weights of items
    int val[] = {60, 100, 120};
    int weight[] = {10, 20, 30}; 
    int W = 50; // Maximum capacity of the knapsack

    // Array to store index and value-to-weight ratio of items
    double ratio[][] = new double[val.length][2]; // 0th col => index, 1st col => ratio

    // Calculate value-to-weight ratio for each item
    for (int i = 0; i < val.length; i++) {
      ratio[i][0] = i;  // Store item index
      ratio[i][1] = val[i] / (double) weight[i]; // Calculate ratio
    }

    // Sort items in ascending order of ratio
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = W; // Remaining capacity of knapsack
    int finalval = 0; // Stores maximum value obtained

    // Iterate from highest to lowest ratio (greedy approach)
    for (int i = ratio.length - 1; i >= 0; i--) {
      int idx = (int) ratio[i][0]; // Get original index of item

      if (capacity >= weight[idx]) { // If item can be fully included
        finalval += val[idx]; // Add full value
        capacity -= weight[idx]; // Reduce capacity
      } else { // If item can only be partially included
        finalval += (capacity * ratio[i][1]); // Add fraction of value
        capacity = 0; // Knapsack is full
        break; // Exit loop
      }
    }
    
    // Print the maximum value obtained
    System.out.println("Maximum value that can be obtained = " + finalval);
  }
}
  