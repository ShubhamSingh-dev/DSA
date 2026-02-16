public class Q5_maxAbsoluteSum {
  public int maxAbsoluteSum(int[] nums) {

    //0 as subaary here is allowed to be empty
    int maxEndingHere = 0;
    int minEndingHere = 0;
    
    int maxSum = 0;
    int minSum = 0;

    for (int i = 0; i < nums.length; i++) {

      //Finding the maxSum
      int c1 = maxEndingHere + nums[i];
      int c2 = nums[i];

      maxEndingHere = Math.max(c1, c2);
      maxSum = Math.max(maxSum, maxEndingHere);

      //Finding the minSum
      int c3 = minEndingHere + nums[i];
      int c4 = nums[i];

      minEndingHere = Math.min(c3, c4);
      minSum = Math.min(minSum, minEndingHere);

    }

    //Finding the absolute sum
    int maxAbs = Math.abs(maxSum);
    int minAbs = Math.abs(minSum);
    
    return Math.max(maxAbs, minAbs);
  }
}