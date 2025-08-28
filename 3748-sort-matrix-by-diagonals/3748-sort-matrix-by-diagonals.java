class Solution {
    private int n;
    private void sortDiagonal(int row,int col,int[][] grid,boolean ascending){
    List<Integer> list = new ArrayList<>();
    int i=row;
    int j=col;

     while(i<n && j<n){
            list.add(grid[i][j]);
            i++;
            j++;
        }

        if(ascending){
            Collections.sort(list); //asscending
        }else{
            list.sort(Collections.reverseOrder());
        }
        i=row;
        j=col;

        for(int ls : list){
            grid[i][j]=ls;
            i++;
            j++;
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        n = grid.length;

        for(int row=0; row<n; row++){
            sortDiagonal(row, 0, grid, false);
        }

        for(int col = 1; col<n; col++){
            sortDiagonal(0,col,grid,true);
        }
        return grid;
    }
}