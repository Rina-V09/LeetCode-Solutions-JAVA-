class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int prevStart = points[0][0];
        int prevEnd = points[0][1];
        int arrows = 1;

        for(int i=0; i<points.length; i++){
            int currStart = points[i][0], currEnd = points[i][1];
            if(currStart>prevEnd){
                arrows++;
                prevStart = currStart;
                prevEnd = currEnd;
            }else{
                prevStart = Math.max(prevStart,currStart);
                prevEnd = Math.min(prevEnd,currEnd);
            }
        }
        return arrows;
    }
}