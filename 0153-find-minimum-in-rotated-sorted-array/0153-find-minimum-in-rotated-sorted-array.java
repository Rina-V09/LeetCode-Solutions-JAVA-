class Solution {
    public int findMin(int[] nums) {
       int low=0,high=nums.length-1,mid;

       while(low<=high){
        mid=low+(high-low)/2;
        if(low==high){
            return nums[low];
        }
        if(nums[low]<=nums[mid]&&nums[high]<nums[low]){
        low=mid+1;}
        else{
            high=mid;
        }

       } 
       return -1;
    }
}