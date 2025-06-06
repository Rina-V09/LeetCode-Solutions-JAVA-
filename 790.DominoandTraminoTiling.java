class Solution{
  public int numTilings(int n){
    if(n<=2) return n;

    int dp[] = new int[n+1];
    dp[1}=1;
    dp[2]=2;
    dp[3]=5;
    int m=1000000000+7;

    for(int i=4; i<=n; i++){
      dp[i]= (2*dp[i-1]%m + dp[i-3]%m)%m;
    }
    return dp[n];
  }
}
