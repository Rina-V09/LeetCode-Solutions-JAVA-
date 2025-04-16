class Solution{
  public long countGood(int[] nums, int k){
    int n=nums.length;
    int i=0,j=0;
    long result=0;
    long pairs=0;

    Map<Integer,Integer> map = new HashMap<>();
    while(j<n){
      int count = map.getOrDefault(nums[j],0);
      pairs+=coount;

      //update frequency
      map.put(nums[j],count+1);
      //Shrink the window from left
      while(pairs>=k){
        result+=(n-j);
        //decrease frequency of nums[i] and update pairs
        int leftFreq=map.get(nums[i]);
        map.put(nums[i], leftFreq-1);
        pairs-=(leftFreq-1);

        i++;
      }
      j++;
    }
    return result;
}
}
