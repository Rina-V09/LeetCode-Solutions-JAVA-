class Solution {
    public int minOperations(int[] nums, int k) {
        int arrSum = 0;

        for(int i:nums){
            arrSum+=i;
            }

            if(arrSum<k){
                return arrSum;
            }

            int rem = arrSum % k; 

        if (rem != 0) {
            for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= rem) {
                nums[i] = nums[i] - rem;
                arrSum = arrSum - rem;   
                break;}
            }
        }
        return rem;
    }
}