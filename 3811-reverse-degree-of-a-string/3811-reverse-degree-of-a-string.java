class Solution {
    public int reverseDegree(String s) {
        int revDegree = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            int reversedidx = 26 - (s.charAt(i)-'a');
            revDegree+=reversedidx*(i+1);
        }
        return revDegree;
    }
}