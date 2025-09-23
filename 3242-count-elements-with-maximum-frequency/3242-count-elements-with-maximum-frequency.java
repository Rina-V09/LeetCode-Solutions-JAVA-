class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num , freqMap.getOrDefault(num,0)+1);
        }

        int maxFreq = 0;
        for(int freq : freqMap.values()){
            maxFreq = Math.max(maxFreq, freq);
        }

        int count=0;
         for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                count += freq;  
            }
        }

        return count;
    }
}