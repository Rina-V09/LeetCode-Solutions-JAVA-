class Solution {
    public int countLargestGroup(int n) {
        int[] groupSizes = new int[37]; // Max digit sum for n <= 10000 is 36 (i.e., 9999 => 9+9+9+9)

        int maxSize = 0;
        int count = 0;

        for (int num = 1; num <= n; num++) {
            int sum = 0, temp = num;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            groupSizes[sum]++;
            if (groupSizes[sum] == maxSize) {
                count++;
            } else if (groupSizes[sum] > maxSize) {
                maxSize = groupSizes[sum];
                count = 1;
            }
        }

        return count;
    }
}
