public class Q1_MaximumSubarraySum {
  public static int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int c1 = currentSum + nums[i];
      int c2 = nums[i];
      
      currentSum = Math.max(c1, c2);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
}
