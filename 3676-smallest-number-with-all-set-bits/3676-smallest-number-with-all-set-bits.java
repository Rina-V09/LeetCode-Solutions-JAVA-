class Solution {
    public int smallestNumber(int n) {
        int i = 1, cnt = 0;
        List<Integer> base = new ArrayList<>();
        while (cnt <= 1000) {
            cnt += i;
            base.add(cnt);
            i *= 2;
        }
        for (int num : base) {
            if (num >= n) return num;
        }
        return -1;
    }
}