class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res; // handle empty matrix case
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0; // Initialize left
        int right = matrix[0].length - 1;

        int d = 0;

        while (top <= bottom && left <= right) {
            if (d == 0) { // left to right
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            } else if (d == 1) { // top to bottom
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            } else if (d == 2) { // right to left
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (d == 3) { // bottom to top
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            d = (d + 1) % 4;
        }

        return res; // Return the result
    }
}
