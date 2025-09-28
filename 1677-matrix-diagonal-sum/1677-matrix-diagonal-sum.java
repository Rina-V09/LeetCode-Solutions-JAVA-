class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // Primary diagonal
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        // Secondary diagonal
        for (int i = 0; i < n; i++) {
            sum += mat[i][n - 1 - i];
        }

        // If n is odd, subtract the center element (counted twice)
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum; 
    }
}
