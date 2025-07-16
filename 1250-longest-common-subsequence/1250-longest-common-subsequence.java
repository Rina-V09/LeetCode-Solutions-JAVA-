class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];

        //for 0th row and 0th col
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        //Bottom up approach
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                //If character is same in both the string then find for rest and add 1
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //if character are different
                    int ans1 = dp[i-1][j]; //making first string shorter and calculate LCS
                    int ans2 = dp[i][j-1]; //making second string shorter and calculate LCS

                    dp[i][j]=Math.max(ans1,ans2);  //Store the max common from the ans1, ans 2
                }
            }
        }
        return dp[n][m];
    }
}