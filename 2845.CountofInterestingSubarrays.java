class Solution{
    public long countInterestingSubarrays(List<Integer> nums, int m, int k){
        int n=nums.size();
        Map<Integer,Long> mp = new HashMap<>();
        long sum = 0;
        long result = 0;

        mp.put(0,1L);
        for(int i=0; i<n; i++){
            if(nums.get(i)%m==k){
                sum+=1;
            }
            int r1=(int)(sum%m);
            int r2=(r1-k+m)%m;

            result+=mp.getOrDefault(r2,0L);
            mp.put(r1,mp.getOrDefault(r1,0L)+1);
        }
        return result;
    }
}
