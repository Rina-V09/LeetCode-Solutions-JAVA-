class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // use amount+1 as a substitute for infinity
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
