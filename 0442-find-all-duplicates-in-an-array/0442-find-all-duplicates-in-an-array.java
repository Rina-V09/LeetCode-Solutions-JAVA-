class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
         
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            if(entry.getValue()>1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}