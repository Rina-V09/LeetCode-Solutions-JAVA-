class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = queries.length;
        int[] ans = new int[m];

        for(int i=0; i<m; i++){
            int k = queries[i];
            int count = 0;
            int sum = 0;

            for(int num : nums){
                if(sum + num <= k){
                    sum += num;
                    count++;
                }else{
                    break;
                }
                ans[i] = count;
            }
        }
        return ans;
    }
}