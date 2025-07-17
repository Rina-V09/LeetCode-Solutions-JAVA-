import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;  // Get the length of the array nums
        int maxLen = 1;       // Initialize the maximum length of valid subsequence as 1 (any single element is trivially valid)

        // Create a 2D dp array:
        // dp[i][mod] will store the length of the longest valid subsequence ending at index i,
        // such that (last two elements' sum) % k == mod
        int[][] dp = new int[n][k];

        // Initialize all dp[i][mod] = 1 for all i and mod
        // Each element by itself is a valid subsequence of length 1 (no pair yet)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        // Start checking every pair (j, i) where j < i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // Calculate the modulo value of the sum of nums[j] and nums[i]
                int mod = (nums[j] + nums[i]) % k;

                // We are trying to extend a valid subsequence that ends at j and has this same mod value
                // If such exists, update dp[i][mod] to reflect the extended length
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);

                // Update the global maximum
                maxLen = Math.max(maxLen, dp[i][mod]);
            }
        }

        // After all iterations, return the maximum length found
        return maxLen;
    }
}
