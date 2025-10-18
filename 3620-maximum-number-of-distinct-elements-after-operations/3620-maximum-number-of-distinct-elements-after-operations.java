class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int current = Integer.MIN_VALUE;
        int count=0;
        for(int num:nums){
            int low = num-k;
            int high = num+k;
            if(current<=high){
                int chosen = Math.max(current,low);
                count++;
                current = chosen+1;
            }
        }
        return count;
    }
}