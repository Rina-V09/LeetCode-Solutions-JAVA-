class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

       
        leftSum[0] = nums[0];
        for(int i=1; i<n; i++){
            leftSum[i] = nums[i] + leftSum[i-1];
        }

        rightSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            rightSum[i] = nums[i] + rightSum[i+1];
        }

        for(int i=0; i<n; i++){
            answer[i] = Math.abs(rightSum[i] - leftSum[i]);
        }
        return answer;
    }
}