class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int a[] = new int[n];
        
        for(int i=0;i<n; i++){
            int j=(k+i)%n;
            a[j] = nums[i];
        }

        for(int i=0;i<n;i++){  //paste a[i] back to nums
            nums[i]=a[i];
        } 
}}