class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) return fruits.length;
        int[] a = { fruits[0], -1 };
        int[] count = { 1, 0 };
        int max = 1;
        int mid = 0;

        for(int i = 1; i < fruits.length; i++) {
            int val = fruits[i];
            if(a[0] == val) count[0] += 1;
            else if(a[1] == val) count[1] += 1;
            else if(a[1] == -1) {
                a[1] = val;
                count[1] = 1;
            } else {
                if(fruits[i - 1] == a[0]) {
                    a[1] = val;
                    count[1] = 1;
                    count[0] = i - mid;
                } else {
                    a[0] = val;
                    count[0] = 1;
                    count[1] = i - mid;
                }
            }

            if(fruits[i -1] != fruits[i]) mid = i;

            if(max < (count[0] + count[1])) max = count[0] + count[1];
        }

        return max;
    }
}