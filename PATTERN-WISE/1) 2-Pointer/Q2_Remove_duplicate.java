public class Q2_Remove_duplicate { 
  public static int remove_duplicate_1(int[] nums){
    if(nums.length == 0) return 0;
    
    int low = 0;
    int high = 1;
    int result = 1;

    while(high < nums.length) {
      if(nums[high] != nums[high - 1]){ //comparing adjacent elements
        low++;
        nums[low] = nums[high];
        result++;
      }
      high++;
    }
    return result;
  }
  
  public static int remove_duplicate_2(int[] nums){
    if(nums.length == 0) return 0;
    
    int i = 0;
    for(int j = 1; j < nums.length; j++){
      if(nums[i] != nums[j]){
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  
}
