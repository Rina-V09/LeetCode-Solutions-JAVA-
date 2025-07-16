class Solution {
    public int lcs(int[] nums, int[]res){
        int n=nums.length;
        int m=res.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n; i++){
            for(int j=1; j<=m ; j++){
                if(nums[i-1]==res[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int[] res = new int[set.size()];
        int i=0;

        for(int ele:set){
            res[i]=ele;
            i++;
        }
        Arrays.sort(res);
        int result = lcs(nums, res);
        return result;
    }
}