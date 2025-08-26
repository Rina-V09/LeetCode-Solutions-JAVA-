class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDiag = 0;
        int maxArea = 0;

        for(int i=0; i<n; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];

            int diagonal = l*l + w*w;
            int area = l * w;

            if(diagonal>maxDiag){
                maxDiag = diagonal;
                maxArea = area;
            }else if(diagonal == maxDiag){
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}