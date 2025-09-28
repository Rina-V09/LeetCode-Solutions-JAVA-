class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int top = 0;
        int bottom =n-1;
        int left = 0;
        int right = n-1;
        int num = 1, d=0;

        while(num<=n*n){
            if(d==0){
                for(int i = left; i<=right; i++){
                    mat[top][i] = num;
                    num++;
                }
                top++;
            }
            else if(d == 1){
                for(int i=top; i<=bottom; i++){
                    mat[i][right] = num;
                    num++;
                }
                right--;
            }
            else if(d == 2){
                for(int i=right; i>=left; i--){
                    mat[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            else if(d==3){
                for(int i = bottom; i>=top; i--){
                    mat[i][left]=num;
                    num++;
                }
                left++;
            }
            d=(d+1)%4;
        }
        return mat;
    }
}