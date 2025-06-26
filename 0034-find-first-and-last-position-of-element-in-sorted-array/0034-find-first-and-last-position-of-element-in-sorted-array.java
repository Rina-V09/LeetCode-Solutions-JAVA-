class Solution {
    public int[] searchRange(int[] nums, int target) {
       int start = findFirst(nums, target);
       int end = findLast(nums, target);
       return new int[]{start, end}; 
    }

    //find first occurrence of target
    private int findFirst(int[] nums, int target){
        int low=0, high=nums.length-1, index=-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                index = mid;
                high = mid-1;  //look more to left
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return index;
    }
 
    //Find the last occurremce of target
    private int findLast(int[] nums, int target){
        int low=0, high=nums.length-1, index=-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                index = mid;
                low = mid+1;  //look more to left
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return index;
    }
}