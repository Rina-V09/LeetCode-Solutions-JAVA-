class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][27];
        //init dp with -1
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return getMaxLenSubSeq(s,k,0,'{',dp);
    }
    public int getMaxLenSubSeq(String s, int k, int index, char lastchar, int dp[][]){
        if(index == s.length()){
            return 0;
        }
        //if state is already visited
        if(dp[index][lastchar-'a']!=-1){
            return dp[index][lastchar-'a'];
        }
        //pick or no pick
        int pick = 0;
        char currentChar = s.charAt(index);
        int diff=Math.abs((int)lastchar - (int)currentChar);
        if(lastchar=='{' || diff<=k){
            pick = 1 + getMaxLenSubSeq(s, k,index+1, currentChar, dp); 
        }
        int nopick = 0 + getMaxLenSubSeq(s, k, index+1, lastchar, dp);
        return dp[index][lastchar-'a']=Math.max(pick,nopick);
    }
}