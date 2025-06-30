class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: Count frequency of each element
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        // Step 2: Check for each number if num + 1 exists
        for (int num : freqMap.keySet()) {
            if (freqMap.containsKey(num + 1)) {
                int currLen = freqMap.get(num) + freqMap.get(num + 1);
                maxLen = Math.max(maxLen, currLen);
            }
        }

        // Step 3: Return the result
        return maxLen;
    }
}
