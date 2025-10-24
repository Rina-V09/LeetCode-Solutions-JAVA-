class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;

        // keep checking numbers until we find a balanced one
        while (true) {
            if (isBalanced(num)) {
                return num;
            }
            num++;
        }
    }

    // helper function to check if a number is numerically balanced
    private boolean isBalanced(int num) {
        String s = String.valueOf(num);
        int[] count = new int[10]; // count digits from 0–9

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                if (count[i] != i) {
                    return false;
                }
            }
        }
        return true;
    }
}
