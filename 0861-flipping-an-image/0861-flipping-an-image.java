class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols/2; j++){
                int temp = image[i][j];
                image[i][j] = image[i][cols - j -1];
                image[i][cols-j-1] = temp;
            }
        
        for(int j=0; j<cols; j++){
            image[i][j] = image[i][j] == 1 ? 0 : 1 ;
        }}
        return image;
    }
}