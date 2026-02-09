class Q6_LongestRepeatingCharacterReplacement {

  // O(n) But O(256 * N)
    // find maximum frequency in 26-size array
    int find(int[] a) {
        int maxc = -1;
        for (int i = 0; i < 26; i++) {
            maxc = Math.max(maxc, a[i]);
        }
        return maxc;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();

        // only A–Z
        int[] freq = new int[26];

        int low = 0;
        int res = Integer.MIN_VALUE;

        for (int high = 0; high < n; high++) {

            // map ASCII 'A'–'Z' → 0–25
            int idxHigh = s.charAt(high) - 'A';
            freq[idxHigh]++;

            int maxCnt = find(freq);
            int len = high - low + 1;
            int diff = len - maxCnt;

            while (diff > k) {
                int idxLow = s.charAt(low) - 'A';
                freq[idxLow]--;
                low++;

                maxCnt = find(freq);
                len = high - low + 1;
                diff = len - maxCnt;
            }

            res = Math.max(res, high - low + 1);
        }

        return res;
    }


  // O(n)
    public int characterReplacement_Optimal(String s, int k) {

        int[] freq = new int[26];
        int low = 0;
        int maxFreq = 0;
        int res = 0;

        for (int high = 0; high < s.length(); high++) {

            int idx = s.charAt(high) - 'A';
            freq[idx]++;

            // update max frequency only when expanding
            maxFreq = Math.max(maxFreq, freq[idx]);

            int windowLen = high - low + 1;
            int diff = windowLen - maxFreq;

            // shrink window if replacements exceed k
            if (diff > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
            }

            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}


/*
 * We use the optimal approach because, in the non-optimal solution,
 * the maximum frequency is recalculated every time the window expands.
 * That recalculation requires scanning the frequency array, which adds
 * extra work at each step.
 *
 * In the optimal solution, we maintain the maximum frequency incrementally
 * while expanding the window, avoiding repeated scans and reducing the
 * overall time complexity to O(n).
 */
