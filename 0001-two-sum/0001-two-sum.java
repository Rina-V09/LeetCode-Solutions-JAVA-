class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] mat = new int[n][2];

        for(int i=0; i<n; i++){
            mat[i][0] = nums[i];
            mat[i][1] = i;
        } 

        Arrays.sort(mat,(a,b) -> Integer.compare(a[0], b[0]));
        int l = 0, r = n-1;
        while(l<r){
            if(mat[l][0] + mat[r][0] == target){
                return new int[]{mat[l][1], mat[r][1]};
            }else if(mat[l][0] + mat[r][0] < target){
                l++;
            }else{
                r--;
            }
        }

        return new int[]{};
    }
}