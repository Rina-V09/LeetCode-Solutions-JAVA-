class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProf = 0;
        int min=prices[0];

        for(int i=0;i<n;i++){
            min = Math.min(min,prices[i]);
            int profit = prices[i]-min;
            maxProf = Math.max(maxProf, profit);
        }

        return maxProf;
    }
}