class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int start = 0;
        int totalsum = 0;
        int pre[]= new int[n+1];
        for(int i=0;i<n;i++)
        pre[i+1]=pre[i]+nums[i];
        for(int i=0;i<n;i++)
        totalsum+=pre[i+1]-pre[Math.max(0,i-nums[i])];
        return totalsum;
    }
}