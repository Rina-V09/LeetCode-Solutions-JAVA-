class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        Arrays.sort(nums);
        int l = 0,r = 1;
        while(l<n && r<n){
            if(l==r || nums[r]-nums[l]<k){
                r++;
            }else if(nums[r]-nums[l] > k){
                l++;
            }else{
                count++;
                l++;
                r++;
                while(r<n && nums[r]==nums[r-1]){
                    r++;
                }
            }
        }
        return count;
    }
}