public class Q3_SubarrWithSumDivisibleByK {
  public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        int result = 0;

        Map<Integer,Integer> remainderCount = new HashMap<>();
        //Base Case
        remainderCount.put(0 , 1);

        for(int i = 0; i < n; i++){
            // Update prefix sum
            prefixSum += nums[i];

            //Find remainder
            int rem = prefixSum % k;
            // Adjust negative remainders to be positive
            if(rem < 0) 
                rem = rem + k;

            // If this remainder has been seen before, it means there are subarrays ending here that are divisible by k
            if(remainderCount.containsKey(rem)){
                result += remainderCount.get(rem);
                remainderCount.put(rem, remainderCount.get(rem) + 1);
            } else {
                remainderCount.put(rem , 1);
            }

        }

        return result;
    }
}