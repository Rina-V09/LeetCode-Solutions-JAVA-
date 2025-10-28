class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;

        // Try each position where nums[i] == 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // Try moving right
                if (canMakeAllZero(nums, i, 1)) {
                    count++;
                }
                // Try moving left
                if (canMakeAllZero(nums, i, -1)) {
                    count++;
                }
            }    
        }
        
        return count;
    }

    // Helper method to simulate the process
    private boolean canMakeAllZero(int[] nums, int start, int dir) {
        int[] arr = nums.clone(); // copy original array
        int n = arr.length;
        int current = start;

        while (current >= 0 && current < n) {
            if (arr[current] == 0) {
                current = current + dir; // move in current direction
            } else {
                arr[current]--;           // decrement value
                dir = -dir;               // reverse direction
                current = current + dir;  // move after reversing
            }
        }

        // Check if all values became zero
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}