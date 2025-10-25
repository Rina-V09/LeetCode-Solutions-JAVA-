class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        
        int total = 0;
        
        // money for complete weeks
        total += 7 * (weeks * (weeks + 1) / 2) + 21 * weeks;
        
        // money for remaining days
        total += days * (weeks + 1) + (days * (days - 1)) / 2;
        
        return total;
    }
}
