class Solution {
    public int countCompleteSubarrays(int[] nums) {
         int n=nums.length;
         int res=0;
         Set<Integer> uniqueSet = new HashSet<>();
         for(int num:nums){
             uniqueSet.add(num);
         }

         int totalDistinct = uniqueSet.size();
         for(int i=0; i<n; i++){
             Set<Integer> windowSet = new HashSet<>();
             for(int j=i; j<n; j++){
                 windowSet.add(nums[j]);
                 if(windowSet.size() == totalDistinct){
                     res += n-j;
                     break;
                 }
             }
         }
        return res;}}

      //Sliding Window Approach
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        int res=0;
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num:nums){
            uniqueSet.add(num);
        }

        int totalDistinct = uniqueSet.size();

        Map<Integer,Integer> freqMap = new HashMap<>();
        int right = 0;
        for(int left=0; left<n; left++){
            if(left>0){
                int toRemove = nums[left-1];
                freqMap.put(toRemove, freqMap.get(toRemove)-1);
                if(freqMap.get(toRemove)==0){
                    freqMap.remove(toRemove);
                }
            }
            while(right<n && freqMap.size()<totalDistinct){
                int toAdd = nums[right];
                freqMap.put(toAdd, freqMap.getOrDefault(toAdd,0)+1);
                right++;
            }
            if(freqMap.size()==totalDistinct){
                res+=(n-right+1);
            }
        }
        return res;
        
    }
}
