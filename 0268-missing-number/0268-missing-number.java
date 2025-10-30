class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int[] B = new int[n+1];
        Arrays.fill(B, -1);

        for(int i = 0; i < n; i++){
            B[nums[i]] = nums[i];  
        }

        for(int i = 0; i <= n; i++){
            if(B[i] == -1)
                return i;
        }
        return -1;
    }
}
