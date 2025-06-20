class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int mid=0;

        while(mid<=right){
            if(nums[mid]==0){
                int temp=nums[left];
                nums[left]=nums[mid];
                nums[mid]=temp;

                mid++;
                left++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp1=nums[mid];
                nums[mid]=nums[right];
                nums[right]=temp1;

                // mid++;
                right--;
            }
        }
        // for(int i=0 ;i<n; i++){
        //     System.out.print(nums[i]+ ",");
        //}
    }
}
