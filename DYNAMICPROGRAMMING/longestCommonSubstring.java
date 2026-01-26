public class longestCommonSubstring {

    //time complexity is O(n*m)
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; // declare ans

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset for substring
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";

        System.out.println("Longest Common Substring Length: " + lcs(str1, str2));
    }
}
