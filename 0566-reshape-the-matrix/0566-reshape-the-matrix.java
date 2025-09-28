class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        if(rows * cols != r * c){
            return mat;
        }

        int[][] res = new int[r][c];
        int[] arr = new int[rows*cols];
        int idx=0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                arr[idx] = mat[i][j];
                idx++;
            }
        }

        idx = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                res[i][j] = arr[idx];
                idx++;
            }
        }
        return res;
    }
}