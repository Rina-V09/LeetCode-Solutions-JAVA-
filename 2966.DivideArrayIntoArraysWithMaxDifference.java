class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // Arrays.sort(nums);  // Step 1: Sort the array
        // int n = nums.length;

        // // Since we divide into groups of 3
        // if (n % 3 != 0) return new int[0][0];

        // int[][] result = new int[n / 3][3]; // Prepare result array
        // int row = 0;

        // for (int i = 0; i < n; i += 3) {
        //     int a = nums[i], b = nums[i + 1], c = nums[i + 2];

        //     // Step 2: Check all pair differences in group of 3
        //     if (Math.abs(a - b) <= k && Math.abs(b - c) <= k && Math.abs(a - c) <= k) {
        //         result[row][0] = a;
        //         result[row][1] = b;
        //         result[row][2] = c;
        //         row++;
        //     } else {
        //         return new int[0][0];  // If not valid, return empty
        //     }
        // }

        // return result;

         int n = nums.length;

        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];  // if n=6 .... 6 / 3 = 2 groups
        int index = 0;

        for (int i = 0; i <= n - 3; i += 3) { (i=0,3,...)
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }

        return result;
    }
}
