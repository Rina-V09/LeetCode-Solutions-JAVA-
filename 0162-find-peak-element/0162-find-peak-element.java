class Solution {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        int mid;

        while(low<high){
            mid=low+(high-low)/2;
            if(high==low){
                return low ;
            }
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}