class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();

        // dp[i][j] = length of the longest common *substring* ending at s[i-1] and r[j-1]
        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0;
        int end = 0; // end index (exclusive) in original string s

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Map j (in reverse string) back to the original index
                    int origStart = n - j; // start index in s for the matched substring
                    int origEnd = i - 1;  // end index in s for the matched substring

                    // Ensure the match is aligned correctly (i.e., it's the same forward substring)
                    if (origStart + dp[i][j] - 1 == origEnd) {
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            end = i;
                        }
                    }
                } else {
                    dp[i][j] = 0; // important for *substring* (not subsequence)
                }
            }
        }

        return s.substring(end - maxLen, end);
    }
}
