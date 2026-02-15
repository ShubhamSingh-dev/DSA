public class Q3_MaximumProductSubarray {
  public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxEnd = nums[0];
        int minEnd = nums[0];

        for(int i = 1; i < nums.length; i++){
            int c1 = nums[i];
            int c2 = maxEnd * nums[i];
            int c3 = minEnd * nums[i];

            maxEnd = Math.max(c1, Math.max(c2,c3));
            minEnd = Math.min(c1, Math.min(c2,c3));

            res = Math.max(res, Math.max(maxEnd, minEnd));
        }

        return res;
    }  
}
