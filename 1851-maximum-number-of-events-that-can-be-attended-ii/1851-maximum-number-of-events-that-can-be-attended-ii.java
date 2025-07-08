class Solution {
    int n;
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        n = events.length;
        dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int nextIndex = binarySearch(events, events[i][1]);
        int take = events[i][2] + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    private int binarySearch(int[][] events, int endTime) {
        int low = 0, high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > endTime)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
