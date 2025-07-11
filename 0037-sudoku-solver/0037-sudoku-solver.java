class Solution {
    boolean ans = false;
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }

    public void solve(int row, int col, char[][] grid){
        //base case
        if(row==grid.length){
            ans = true;
            return;
        }
        int next_row = -1;
        int next_col = -1;
        if(col == grid.length-1){
            next_row=row+1;
            next_col =0;
        }else{
            next_row=row;
            next_col=col+1;
        }

        //already exist
        if(grid[row][col]!='.'){
            solve(next_row,next_col,grid);
        }else{
            for(char i='1'; i<='9'; i++){
                if(isPossible(row,col,i,grid)){
                    grid[row][col]=i;
                    solve(next_row, next_col,grid);

                    //backtrack
                    if(ans==true) return;
                    grid[row][col]='.';
                }
            }
        }
    }

    public boolean isPossible(int row, int col, char num, char[][] grid){
        //col
        for(int i=0; i<9; i++){
            if(grid[i][col]==num) return false;
        }

        //row
        for(int i=0; i<9; i++){
            if(grid[row][i]==num) return false;
        }

        //matrix
        int x=(row/3)*3;
        int y=(col/3)*3;
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(grid[i][j]==num) return false;
            }
        }
        return true;
    }
}