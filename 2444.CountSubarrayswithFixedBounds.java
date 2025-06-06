class Solution{
  public long countSubarrays(int[] nums, int minK, int maxK){
    int minI=-1;
    int maxI=-1;
    int LeftBoundary=-1;
    long ans = 0;
    int n=nums.length;

    for(int current=0; current<n; current++){
      if(nums[current]==minK){
        minI=current;
      }
      if(nums[current]==maxK){
        maxI=current;
      }

      //check if current element is out of bound
      if(nums[current] <minK || nums[current]>maxK){
        leftBoundary=current;
      }
      if(minI!=-1 && maxI!=-1){
        int smaller = Math.min(maxI, minI);
        if(smaller-leftBoundary>0){
          ans+=smaller-leftBoundary;
        }
      }
    }
    return ans;
  }
}
