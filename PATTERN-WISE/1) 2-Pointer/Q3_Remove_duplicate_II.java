public class Q3_Remove_duplicate_II {
  
 public int removeDuplicates_II(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2; 

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

