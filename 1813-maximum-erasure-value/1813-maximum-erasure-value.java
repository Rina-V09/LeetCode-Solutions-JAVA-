class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int maxSum = 0, curSum=0;
        int left = 0, right = 0;

        while(right<n){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                curSum = curSum + nums[right];
                maxSum = Math.max(maxSum, curSum);
                right++;
            }else{
                if(nums[left]!=nums[right]){
                    set.remove(nums[left]);
                    curSum = curSum-nums[left];
                    left++;
                }
                set.remove(nums[left]);
                curSum = curSum - nums[left];
                left++;
            }
        }
        return maxSum;
    }
}