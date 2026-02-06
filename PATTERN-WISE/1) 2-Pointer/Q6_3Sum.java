import java.util.*;

public class Q6_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = n - 1;
            int sum = -nums[i];

            while (left < right) {
                int s = nums[left] + nums[right];

                if (s == sum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicate second elements
                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    // Skip duplicate third elements
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                } else if (s < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
