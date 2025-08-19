class Solution {
    public long zeroFilledSubarray(int[] nums) {
       long result = 0;
       int i = 0;

       while(i<nums.length){
        long count = 0;
        if(nums[i] == 0){
            while(i<nums.length && nums[i]==0){   //subarray having 0 [0,0]
            count++;
            i++;
        }
        }else{
            i++;
        }
        result+=(count)*(count+1)/2; 
       }    
       return result;
    }
}