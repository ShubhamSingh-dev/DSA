import java.util.HashMap;
import java.util.Map;

public class Q4_ContiguousArray {
  public int findMaxLength(int[] nums) {
    int zeroes = 0;
    int ones = 0;
    int result = 0;
    
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      
      //Checking if the current number is 0 or 1 and incrementing the corresponding count variable
      if (nums[i] == 0) 
        zeroes++; 
      else 
        ones++;

      int diff = zeroes - ones;

      if(diff == 0) {
        result = Math.max(result, i + 1);
        continue;
      }

      if(map.containsKey(diff)){
          int idx = map.get(diff);
          int len = i - idx;
          result = Math.max(result, len);
        } else {
          map.put(diff, i);
      }
    }

    return result; 
  }
}
