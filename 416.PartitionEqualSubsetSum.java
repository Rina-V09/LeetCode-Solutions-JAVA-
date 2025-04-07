class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return canPartitionRecursive(nums, 0, target, memo);
    }

    private boolean canPartitionRecursive(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        // Choose the number
        if (canPartitionRecursive(nums, index + 1, target - nums[index], memo)) {
            memo[index][target] = true;
            return true;
        }

        // Or skip the number
        memo[index][target] = canPartitionRecursive(nums, index + 1, target, memo);
        return memo[index][target];
    }
}
