import java.util.*;

public class LargestSubarrSum0 { //TC= O(n)
  public static void main(String[] args) {
    int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

    HashMap<Integer, Integer> map = new HashMap<>();
    // (sum, index)
    int sum = 0;
    int len = 0;

    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];

      if (sum == 0) {
        len = j + 1;  // entire subarray from 0 to j
      }

      if (map.containsKey(sum)) {
        len = Math.max(len, j - map.get(sum));
      } else {
        map.put(sum, j);
      }
    }

    System.out.println("Length of largest subarray with 0 sum: " + len);
  }
}
