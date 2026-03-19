import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 503 - Next Greater Element II (Circular Array)
 *
 * This class provides two different approaches to solve the problem of finding
 * the next greater element for each element in a circular array.
 *
 * Problem Summary:
 * Given a circular integer array `nums`, return an array `res` such that:
 * - res[i] is the next greater number of nums[i]
 * - If no such number exists, return -1 for that index
 *
 * Circular Nature:
 * The array wraps around, meaning after the last element, we continue from the beginning.
 *
 * Example:
 * nums = [1, 2, 1]
 * result = [2, -1, 2]
 *
 * Core Concept Used:
 * Monotonic Decreasing Stack
 * - Stack stores elements in decreasing order
 * - Helps efficiently find next greater elements in O(n)
 */
public class Q4_NextGreaterII {

  /**
   * Approach 1: Pre-fill Stack to Simulate Circular Array
   *
   * Idea:
   * Instead of iterating twice, we simulate the circular behavior by
   * pre-loading the stack with elements from the array (excluding last element).
   *
   * Steps:
   * 1. Pre-fill stack with elements from index (n-2 → 0)
   *    → This simulates the "right side" of circular traversal.
   * 2. Traverse array from right to left.
   * 3. Maintain a monotonic decreasing stack:
   *    - Pop elements smaller or equal to current
   *    - Top of stack becomes next greater element
   * 4. Push current element into stack.
   *
   * Why it works:
   * - Pre-filled stack ensures elements can "see" circularly ahead.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *
   * Note:
   * - Slightly less intuitive due to manual stack pre-fill.
   * - Can be tricky to reason about in interviews.
   */
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Stack<Integer> st = new Stack<>();

    // Pre-fill stack to simulate circular behavior
    for (int i = n - 2; i >= 0; i--) {
      st.push(nums[i]);
    }

    // Traverse from right to left
    for (int i = n - 1; i >= 0; i--) {

      // Remove all smaller or equal elements
      while (!st.isEmpty() && st.peek() <= nums[i]) {
        st.pop();
      }

      // Assign result
      res[i] = st.isEmpty() ? -1 : st.peek();

      // Push current element
      st.push(nums[i]);
    }

    return res;
  }

  /**
   * Approach 2 (Preferred): Simulate Circular Array Using 2N Traversal
   *
   * Idea:
   * Instead of manually pre-filling the stack, we iterate through the array twice
   * using modulo indexing (i % n) to simulate circular traversal.
   *
   * Steps:
   * 1. Iterate from (2n - 1) → 0
   * 2. Use (i % n) to access elements circularly
   * 3. Maintain a monotonic decreasing stack:
   *    - Pop all smaller or equal elements
   *    - Stack top gives next greater element
   * 4. Only fill result when i < n (first pass)
   *
   * Why it works:
   * - Second traversal ensures each element has access to elements "ahead"
   *   in a circular manner.
   *
   * Why this is preferred:
   * ✔ More intuitive and standard pattern
   * ✔ No manual pre-processing (less error-prone)
   * ✔ Easier to explain in interviews
   * ✔ Reusable template for similar problems
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   */
  public int[] nextGreaterElements_2ndWay(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();

    for (int i = 2 * n - 1; i >= 0; i--) {
      // i % n ensures circular traversal of the array
// When i >= n, it wraps around to the beginning
// i % n wraps index back to [0, n-1]
// Example: for n = 3 → indices go like: 5→2, 4→1, 3→0
      int num = nums[i % n];

      // Maintain decreasing stack
      while (!stack.isEmpty() && stack.peek() <= num) {
        stack.pop();
      }

      // Fill result only in first pass
      if (i < n && !stack.isEmpty()) {
        result[i] = stack.peek();
      }

      // Push current element
      stack.push(num);
    }

    return result;
  }
}