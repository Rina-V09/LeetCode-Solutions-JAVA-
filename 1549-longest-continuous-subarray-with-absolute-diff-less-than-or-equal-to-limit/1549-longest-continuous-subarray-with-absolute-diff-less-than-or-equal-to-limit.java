class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int i = 0, res = 0;

        for (int j = 0; j < nums.length; j++) {

            // decreasing max deque
            while (!maxD.isEmpty() && maxD.peekLast() < nums[j]) {
                maxD.pollLast();
            }
            maxD.addLast(nums[j]);

            // increasing min deque
            while (!minD.isEmpty() && minD.peekLast() > nums[j]) {
                minD.pollLast();
            }
            minD.addLast(nums[j]);

            // invalid → shrink from left
            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peekFirst() == nums[i])
                    maxD.pollFirst();
                if (minD.peekFirst() == nums[i])
                    minD.pollFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
