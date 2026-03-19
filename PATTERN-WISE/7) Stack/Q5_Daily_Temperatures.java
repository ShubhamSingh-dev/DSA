import java.util.*;

/**
 * LeetCode 739 - Daily Temperatures
 *
 * This class contains two monotonic stack approaches:
 * 1. Right → Left (Next Greater Element / Future Lookup)
 * 2. Left → Right (Resolve Previous / Pending Elements)
 */
class Q5_Daily_Temperatures {

    /* =========================================================
       Approach 1: Right → Left (Future Lookup)
       ========================================================= */

    /**
     * Computes the number of days until a warmer temperature
     * using a monotonic decreasing stack (right-to-left traversal).
     *
     * Approach:
     * - Traverse from right to left.
     * - Maintain a stack storing indices of future days with higher temperatures.
     * - For each day:
     *   - Pop all indices whose temperatures are less than or equal to current.
     *   - The top of the stack (if any) is the next warmer day.
     *   - Compute the difference in indices.
     *
     * Stack Invariant:
     * - Stack stores indices of strictly increasing temperatures (from top to bottom).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param temperatures Array of daily temperatures
     * @return An array where each element represents the number of days
     *         to wait for a warmer temperature (0 if none exists)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>(); // stores indices
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            } else {
                res[i] = 0;
            }

            st.push(i);
        }

        return res;
    }

    /* =========================================================
       Approach 2: Left → Right (Resolve Previous)
       ========================================================= */

    /**
     * Computes the number of days until a warmer temperature
     * using a monotonic decreasing stack (left-to-right traversal).
     *
     * Approach:
     * - Traverse from left to right.
     * - Maintain a stack storing indices of days waiting for a warmer temperature.
     * - For each day:
     *   - While current temperature is greater than the temperature at stack top:
     *     - Pop the index and resolve the waiting days.
     *   - Push the current index onto the stack.
     *
     * Stack Invariant:
     * - Stack stores indices of unresolved days in decreasing temperature order.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param temperatures Array of daily temperatures
     * @return An array where each element represents the number of days
     *         to wait for a warmer temperature (0 if none exists)
     */
    public int[] dailyTemperatures_front(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}