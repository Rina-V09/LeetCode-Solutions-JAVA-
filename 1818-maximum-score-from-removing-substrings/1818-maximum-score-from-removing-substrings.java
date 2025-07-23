class Solution {
    public int maximumGain(String s, int x, int y) {
        // Decide the order of removal
        if (y > x) {
            // Remove "ba" first if it's worth more
            return removeSubstrings(s, 'b', 'a', y, x);
        } else {
            // Otherwise, remove "ab" first
            return removeSubstrings(s, 'a', 'b', x, y);
        }
    }

    private int removeSubstrings(String s, char first, char second, int firstScore, int secondScore) {
        Stack<Character> stack = new Stack<>();
        int total = 0;

        // First pass - remove high-value substring
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop(); // Remove the pair
                total += firstScore;
            } else {
                stack.push(c);
            }
        }

        // Build new string after first pass
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }

        // Second pass - remove the other pair in reverse order
        s = remaining.reverse().toString();
        stack.clear();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && c == first) {
                stack.pop(); // Remove the second pair
                total += secondScore;
            } else {
                stack.push(c);
            }
        }

        return total;
    }
}
