//? Uses: Dutch National Flag Algorithm

public class Q9_Sort_colors {
  private static void swap(int[] nums ,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Dutch National Flag Algorithm : 2 Pointer
    public void sortColors(int[] nums) {
        int n = nums.length;

        int low = 0,high = n - 1,mid = 0;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }      
    }
}
