//TC-O(N3)

class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxSum=0;
        int n=nums.length;
         for(int i=0;i<n-2;i++){
             for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                     maxSum=Math.max(maxSum,(long)(nums[i]-nums[j])* nums[k]);
                }
             }
         }
        return maxSum;
    }}

//TC-O(N)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxSum=0;
        int n=nums.length;
        long res=0,imax=0,dmax=0;
        for(int k=0;k<n;k++){
            res=Math.max(res,dmax*nums[k]);
            dmax=Math.max(dmax,imax-nums[k]);
            imax=Math.max(imax,nums[k]);
        }
        return res;
    }
}
