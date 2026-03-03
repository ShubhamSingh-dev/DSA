import java.util.Arrays;
import java.util.Stack;

public class Q4_NextGreaterII {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1); //Default answer is -1
    Stack<Integer> stack = new Stack<>();

    for(int i = n -2 ; i >= 0 ; i-- ){
      while(!stack.isEmpty() && stack.peek() <= nums[i]){
        stack.pop();
      }

      if(stack.isEmpty()){
        result[i] = -1;
      } else {
        result[i] = stack.peek();
      }

      stack.push(nums[i]);
    }

    return result;
  }
}