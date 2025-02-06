import java.util.*;

public class MaxLengthChainOfPairs {

  public static void main(String[] args) { // TC = O(nlogn)
    // Define an array of pairs
    int[][] pairs = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
    
    // Sort pairs based on the second element
    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int chainlen = 1; // Initialize chain length
    int chainEnd = pairs[0][1]; // Last selected pair end

    // Iterate over sorted pairs to find the maximum length of chain
    for (int i = 1; i < pairs.length; i++) {
      // If the current pair can be added to the chain
      if (pairs[i][0] > chainEnd) {
        chainlen++; // Increment the chain length
        chainEnd = pairs[i][1]; // Update the end of the current chain
      }
    }
    // Output the maximum length of the chain
    System.out.println("Max length of chain = " + chainlen);
  }
}
