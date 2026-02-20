import java.util.HashMap;
public class Q2_SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // base case

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            // Add current element to sum so far.
            prefixSum += num;

            // If currSum is equal to desired sum
            // then a new subarray is found.
            if(prefixSum == k) {
                count++;
            }
            int val = prefixSum - k;
            // Check if there exists a prefixSum - k
            if (map.containsKey(val)) {
                count += map.get(val);
            }

            // Store/update current prefixSum frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;

    }
}



// ? If Didnt understand use GFG Website
