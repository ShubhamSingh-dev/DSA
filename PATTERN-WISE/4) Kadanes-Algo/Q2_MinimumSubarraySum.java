public class Q2_MinimumSubarraySum {
  static int smallestSumSubarray(int a[], int size) {
    int minSum = a[0];
    int currentSum = a[0];

    for (int i = 1; i < a.length; i++) {
      int c1 = currentSum + a[i];
      int c2 = a[i];
      
      currentSum = Math.min(c1, c2);
      minSum = Math.min(minSum, currentSum);
    }
    return minSum;
    }  
}
