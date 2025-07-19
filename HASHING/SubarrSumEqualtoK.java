import java.util.*;

public class SubarrSumEqualtoK { // TC=O(n) SC=O(n)
  public static void main(String[] args) {
    int arr[] = {10, 2, -2, -20, 10};
    int k = -10;

    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int count = 0;

    // To handle the case when subarray starts from index 0
    map.put(0, 1);

    for (int j = 0; j < arr.length; j++) {// TC=O(n)
      sum += arr[j];

      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    System.out.println("Total subarrays with sum " + k + " = " + count);
  }
}
