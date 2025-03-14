//Binary Search Approach

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;
        
        // Check if all indices can be made zero using all queries
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary search to find the minimum number of queries needed
        while (left <= right) {
            int middle = (left + right) / 2;
            
            // If it's possible to make all elements zero with 'middle' queries,
            // try a smaller number of queries
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1; // Otherwise, increase the number of queries
            }
        }
        return left; // Return the minimum number of queries needed
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1]; // Difference array for efficient range updates

        // Apply the first 'k' queries using the difference array approach
        for (int qi = 0; qi < k; qi++) {
            int left = queries[qi][0];
            int right = queries[qi][1];
            int val = queries[qi][2];

            differenceArray[left] += val;  // Start incrementing at 'left'
            differenceArray[right + 1] -= val; // Stop incrementing after 'right'
        }

        // Apply the prefix sum to get the actual array values
        for (int ni = 0; ni < n; ni++) {
            sum += differenceArray[ni]; // Update current element value
            if (sum < nums[ni]) { // If at any point, the modified value is less than the original
                return false; // It's not possible to make all elements zero
            }
        }
        return true; // If all elements are non-negative, return true
    }
}


//Line Sweep
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;  
        int[] differenceArray = new int[n + 1]; // Difference array for range updates

        // Iterate through each index of nums
        for (int index = 0; index < n; index++) {
            // While the current index value (sum + differenceArray[index]) is less than nums[index],
            // keep applying more queries to increase it.
            while (sum + differenceArray[index] < nums[index]) {
                k++; // Increase the count of queries used

                // If we use more queries than available, it's not possible to make all elements zero
                if (k > queries.length) {
                    return -1;
                }

                // Extract query details (left index, right index, value to add)
                int left = queries[k - 1][0];
                int right = queries[k - 1][1];
                int val = queries[k - 1][2];

                // Apply the query only if it affects the current index
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val; // Start incrementing from max(left, index)
                    differenceArray[right + 1] -= val; // Stop incrementing after 'right'
                }
            }
            sum += differenceArray[index]; // Apply prefix sum
        }
        return k; // Return the minimum number of queries used
    }
}
