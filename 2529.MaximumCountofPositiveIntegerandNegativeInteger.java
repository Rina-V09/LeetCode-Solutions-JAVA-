//LINEAR SEARCH O(N)
class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int neg=0;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]>0){
                pos++;

            }
            if(nums[i]<0){
                neg++;
            }
        }
        return Math.max(pos,neg);
    }
}

//BINARY SEARCH O(Log(n))
class Solution {
    public int maximumCount(int[] nums) {
       //first>-1-->Negative
       //first>0-->Positive

       int n=nums.length;
       int end=n-1;
       int negPos=binarySearch(nums,0,end,-1);
       int posPos=binarySearch(nums,negPos,end,0);
       int posCount=(n-posPos);
       return Math.max(negPos,posCount);
    }

    public int binarySearch(int nums[],int start,int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target){
                start=mid+1;

            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}
