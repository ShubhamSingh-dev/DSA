class Q2_MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, sum = 0;
        int res = Integer.MAX_VALUE;

        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];

            while (sum >= target) {
                int len = high - low + 1;
                res = Math.min(res, len);
                sum -= nums[low];
                low++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}