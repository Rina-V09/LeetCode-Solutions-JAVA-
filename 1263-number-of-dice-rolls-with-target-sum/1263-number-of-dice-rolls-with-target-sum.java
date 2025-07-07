class Solution {
    int mod = (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo=new Integer[n+1][target+1];
        return numRollsToTarget(n, k, target, memo);
        }

    public int numRollsToTarget(int n, int k, int target, Integer[][] memo){
        if(n==0)
            return target==0?1:0;
        if(target<0)
            return 0;
        if(memo[n][target]!=null)
            return memo[n][target];

        int res=0;
        for(int i=1; i<=k; i++){
            res =(res + numRollsToTarget(n-1,k,target-i,memo))%mod;
        }

        return memo[n][target]=res;
    }
}