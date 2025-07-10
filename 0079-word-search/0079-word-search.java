class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n= board[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans = search(board, i, j, word, 0, vis);
                if(ans){
                    return true;
                }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int row, int col,String word, int ind,boolean[][] vis){
        if(ind == word.length()){
            return true;
        }

        if(row>=board.length || row<0 || col<0 || col>=board[0].length || board[row][col]!=word.charAt(ind) || vis[row][col]==true){
            return false;
        }

        vis[row][col]=true;
        boolean opt1 = search(board, row+1, col, word, ind+1, vis);
        boolean opt2 = search(board, row-1, col, word, ind+1, vis);
        boolean opt3 = search(board, row, col+1, word, ind+1, vis);
        boolean opt4 = search(board, row, col-1, word, ind+1, vis);
        vis[row][col]=false;

        return opt1||opt2||opt3||opt4;
    }
}