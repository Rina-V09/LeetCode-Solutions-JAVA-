class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length!=m*n){
            return new int[][] {};
        }

        int[][] result = new int[m][n];
        int idx = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j] = original[idx];
                idx++;
            }
        }
        return result;
    }
}