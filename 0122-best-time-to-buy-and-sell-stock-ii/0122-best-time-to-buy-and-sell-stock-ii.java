class Solution {
    public int maxProfit(int[] arr) {
        int totalProf = 0;

        int min = arr[0],max = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }else if(arr[i]<max && max>min){
                totalProf += (max-min);
                max = arr[i];
                min = arr[i];
            }else if(arr[i]<min){
                min = arr[i];
                max = arr[i];
            }
        }

        if(max>min){
            totalProf+= (max-min);
        }
        return totalProf;
    }
}