public class Q6_maxSubarraySumCircular {
  public int maxSubarraySumCircular(int[] nums) {
        
        int totalSum = nums[0];
        
        int currMax = nums[0];
        int maxSum = nums[0];
        
        int currMin = nums[0];
        int minSum = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++){
            
            //Case 1: If subarry is in middle : // Standard Kadane for max subarray
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);
            
            //Case 2: If Subarray is circular: // Kadane for min subarray
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
            
            totalSum += nums[i];
        }

        // If all numbers are negative
        if(maxSum < 0){
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
