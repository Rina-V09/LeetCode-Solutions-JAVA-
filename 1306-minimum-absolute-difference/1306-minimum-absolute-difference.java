class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            minDiff = Math.min(minDiff,arr[i]-arr[i-1]);
        }
        
        for(int i=1; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            if(arr[i]-arr[i-1] == minDiff){
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}