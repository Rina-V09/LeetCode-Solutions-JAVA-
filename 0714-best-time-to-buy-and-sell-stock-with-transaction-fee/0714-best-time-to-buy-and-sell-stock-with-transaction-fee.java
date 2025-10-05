class Solution {
    public int maxProfit(int[] prices, int fee) {
        int have = -prices[0];
        int empty = 0;

        for(int i=1; i<prices.length; i++){
            have = Math.max(have,empty-prices[i]);
            empty = Math.max(empty,have+prices[i]-fee);
        }
        return empty;
    }
}