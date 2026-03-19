import java.util.*;

/**
 * LeetCode 1209 - Remove All Adjacent Duplicates in String II
 *
 * This class provides a method to remove all adjacent duplicates in a string
 * where a character appears k times consecutively.
 *
 * Problem Statement:
 * Given a string `s` and an integer `k`, repeatedly remove groups of
 * k adjacent identical characters until no more such groups exist.
 *
 * Example:
 * Input:  s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 *
 * Approach:
 * This solution uses a Stack of Pair objects to track characters and their frequencies.
 *
 * Core Idea:
 * - Maintain a stack where each element (Pair) stores:
 *   1. A character
 *   2. Its consecutive frequency
 *
 * Algorithm:
 * 1. Traverse the string from left to right.
 * 2. For each character:
 *    - If it matches the top of the stack, increment its count.
 *    - If count becomes equal to k, remove that entry from the stack.
 *    - Otherwise, push a new Pair onto the stack.
 * 3. After processing the string, reconstruct the result:
 *    - Iterate through the stack from bottom to top.
 *    - Append each character 'count' times to the result.
 *
 * Why Stack?
 * - Helps track consecutive characters efficiently.
 * - Supports removal of k duplicates in O(1) time.
 *
 * Important Note:
 * - Java Stack extends Vector, so `get(i)` allows traversal from bottom to top.
 * - This preserves the correct order while rebuilding the string.
 *
 * Time Complexity: O(n)
 * - Each character is pushed and popped at most once.
 *
 * Space Complexity: O(n)
 * - Stack stores at most n elements in worst case.
 */
public class Q6_RemoveAdjacentByKinString {

    /**
     * Helper class to store character and its frequency.
     */
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    /**
     * Removes all adjacent duplicates of length k from the string.
     *
     * @param s the input string
     * @param k the number of consecutive duplicates required for removal
     * @return the resulting string after all possible removals
     */
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();

        // Traverse the string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // If same as top character, increment count
            if (!st.empty() && st.peek().ch == c) {
                st.peek().count++;

                // Remove when count reaches k
                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                // Push new character
                st.push(new Pair(c, 1));
            }
        }

        // Build result string from stack (bottom → top)
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < st.size(); i++) {
            Pair p = st.get(i);

            for (int j = 0; j < p.count; j++) {
                result.append(p.ch);
            }
        }

        return result.toString();
    }
}