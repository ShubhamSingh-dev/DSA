import java.util.Arrays;

public class Q7_3Sum_closest {
   public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;

    int minDiff = Integer.MAX_VALUE;
    int closestSum = 0;

    for(int i =0;i<n-2;i++){
      int left = i+1;
      int right = n-1;

      while(left < right){
        int currentSum = nums[i] + nums[left] + nums[right];
        int diff = Math.abs(currentSum - target);

         if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum; // exact match
                }
      }
    }

    return closestSum;
   } 
}
