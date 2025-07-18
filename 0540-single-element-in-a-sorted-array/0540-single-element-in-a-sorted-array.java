class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int mid;
        int high=nums.length-1;

        while(low<high){
             mid=low+(high-low)/2;
             
             if(mid%2==0 && nums[mid]==nums[mid+1]||mid%2==1 && nums[mid]==nums[mid-1]){
                low=mid+1;
             }
             else{
                high=mid;
             }
        }
        return nums[low];
    }
}