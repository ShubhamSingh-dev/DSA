public class StringConversion {

  // time complexity O(n*m)
  public static int stringConversion(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // dp[i][j] = LCS length of s1[0..i-1] and s2[0..j-1]
    int[][] dp = new int[n + 1][m + 1];

    // build LCS table
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    int lcs = dp[n][m];

    int deletions = n - lcs;
    int insertions = m - lcs;

    return deletions + insertions;
  }

  public static void main(String[] args) {
    String s1 = "pear";
    String s2 = "sea";

    System.out.println(stringConversion(s1, s2)); // Output: 3
  }
}
