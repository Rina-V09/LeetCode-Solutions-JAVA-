class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        
        // Find the maximum candy count in any pile
        for (int candy : candies)
            max = Math.max(max, candy);

        int low = 1, high = max;
        
        // Binary search to find the maximum pile size we can allocate
        while (low <= high) { 
            int mid = low + (high - low) / 2;
            
            // If we can distribute at least k piles of size 'mid', try increasing pile size
            if (canAllocateCandies(candies, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1; // Otherwise, decrease pile size
            }
        }
        return high; // 'high' will be the largest valid pile size
    }

    private boolean canAllocateCandies(int[] candies, long k, int pileSize) {
        if (pileSize == 0) return false; // Can't distribute piles of size 0

        long totalChildrenSupported = 0;
        
        // Count how many children can be supported with 'pileSize'
        for (int candy : candies) {
            totalChildrenSupported += candy / pileSize;
            if (totalChildrenSupported >= k) 
                return true; // If we have enough, return true early
        }
        
        return false;
    }
}
