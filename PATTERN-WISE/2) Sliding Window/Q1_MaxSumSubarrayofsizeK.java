public class Q1_MaxSumSubarrayofsizeK {
  public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // sum of first k elements
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // slide the window
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
  
}
