import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;

        // Step 1: Compute increasing sequence lengths
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Step 2: Check for adjacent increasing subarrays of length k
        for (int i = k; i + k <= n; i++) {
            if (inc[i - 1] >= k && inc[i + k - 1] >= k) {
                return true;
            }
        }

        return false;
    }
}
