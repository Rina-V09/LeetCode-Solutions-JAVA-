class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int x = bounds[0][0];
        int y = bounds[0][1];

        for(int i=1; i<=n-1; i++){
            int a = bounds[i][0];
            int b = bounds[i][1];
            int diff = original[i] - original[i-1];
            x = x + diff;
            y = y + diff;

            x = Math.max(x,a);
            y = Math.min(y,b);
        }
        return Math.max(y-x+1,0);
    }
}