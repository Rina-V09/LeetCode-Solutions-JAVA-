class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minVal = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                minVal = nums[i]; // update minVal if we find a new minimum
            }
        }
        
        return maxDiff;
    }
}
