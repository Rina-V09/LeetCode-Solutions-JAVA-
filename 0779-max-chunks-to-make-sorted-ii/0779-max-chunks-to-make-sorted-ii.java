class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];  //Max
        int[] right = new int[n]; //Min 

        left[0] = arr[0];
        for(int i=1; i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]);  //Fill left array
        }

        right[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.min(right[i+1],arr[i]);  //Fill right array with min values
        }
        
        int chunk = 0;
        for(int i=0; i<n-1; i++){
            if(left[i] <= right[i+1]){
                chunk++;
            }
        }

        return chunk+1;
    }
}