class Solution {
    public int subsetXORSum(int[] nums) {
        return findXorTotal(nums, 0, 0);
    }

    private int findXorTotal(int[] nums, int index, int xor) {
        // base case
        if (index == nums.length) return xor;

        // Include the current element in the subset (pick)
        int pick = findXorTotal(nums, index + 1, xor ^ nums[index]);

        // Exclude the current element from the subset (no pick)
        int noPick = findXorTotal(nums, index + 1, xor);

        return pick + noPick;
    }
}
