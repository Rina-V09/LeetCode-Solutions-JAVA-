class Solution {
    public int lengthOfLIS(int[] nums) {
    int[] res = new int[nums.length];
    int n = nums.length;
    int[] dp = new int[n];
    int maxLength = 1;

    for (int i = 0; i < n; i++) {
        dp[i] = 1;  // every element is a subsequence of length 1
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        res[i] = dp[i]; // optional: fill the result array
        maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
}
}