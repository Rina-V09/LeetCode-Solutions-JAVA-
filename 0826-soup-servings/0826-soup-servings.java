class Solution {
    private double[][] memo;

    private double func(int a, int b) {

        // if a is empty
        if (a <= 0 && b > 0) {
            return 1;
        }

        // if b and a both empty
        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        if (b <= 0 && a >= 0) {
            return 0;
        }

        if (memo[a][b] != -1) return memo[a][b];

        double ch1 = func(a - 4, b - 0);
        double ch2 = func(a - 3, b - 1);
        double ch3 = func(a - 2, b - 2);
        double ch4 = func(a - 1, b - 3);

        return memo[a][b] = 0.25 * (ch1 + ch2 + ch3 + ch4);
    }

    public double soupServings(int n) {
        // 25 * 1 = 25 , 25 * 2 = 50, 25 * 3 = 75, 25 * 4 = 100

        if (n > 4800) return 1; // damn conditionn

        // n is big shrink n by using 25
        int y = (int) Math.ceil((double) n / 25.0);

        memo = new double[y + 1][y + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= y; j++) {
                memo[i][j] = -1;
            }
        }

        return func(y, y);
    }
}