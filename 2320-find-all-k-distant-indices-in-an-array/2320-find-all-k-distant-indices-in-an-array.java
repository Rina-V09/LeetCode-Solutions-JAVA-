class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
         Set<Integer> resultSet = new HashSet<>();
        int n = nums.length;

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    resultSet.add(i);
                }
            }
        }

        // Convert to list and sort
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}