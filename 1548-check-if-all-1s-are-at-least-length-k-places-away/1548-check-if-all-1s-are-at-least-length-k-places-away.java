class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIdx = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                if(lastIdx!=-1){
                    int dist = i - lastIdx - 1;

                    if(dist<k){
                        return false;
                    }
                }
                lastIdx = i;
            }
        }
        return true;
    }
}