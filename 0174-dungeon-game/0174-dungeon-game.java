class Solution {
    public int solve(int i, int j,int row, int col, int[][] dungeon, int[][] dp){

        if(i>=row || j>=col){
            return Integer.MAX_VALUE;
        }

        if (i == row - 1 && j == col - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right = solve(i,j+1,row,col,dungeon,dp);
        int down = solve(i+1,j,row, col, dungeon, dp);

        int min = Math.min(right,down);
        int total = min - dungeon[i][j];

        return dp[i][j]=Math.max(1,total);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row+1][col+1];

        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return solve(0,0,row,col,dungeon,dp);
    }
}