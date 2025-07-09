class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int lp = 1, rp = 1;
        int res = 0;

        if(n==1){
        return nums[0];}
        
        for(int i=0;i<n; i++){
            lp = lp==0?1:lp;
            rp = rp==0?1:rp;
            lp = lp * nums[i];
            rp = rp * nums[n-1-i];

            res = Math.max(res, Math.max(lp,rp));
        }
        return res;
    }
}