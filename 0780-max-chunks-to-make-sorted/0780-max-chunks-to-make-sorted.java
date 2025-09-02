class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        if(n==0) return 0;

        int chunks = 0;
        int max = arr[0];

        for(int i=0; i<n; i++){
            max = Math.max(max,arr[i]);
            if(max == i){
                chunks++;
            }
        }
        return chunks;
    }
}