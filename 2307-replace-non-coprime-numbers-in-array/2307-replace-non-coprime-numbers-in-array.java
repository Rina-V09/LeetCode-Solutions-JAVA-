import java.util.*;

class Solution {
    // Function to compute gcd
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Function to compute lcm
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int x : nums) {
            int cur = x;
            while (!stack.isEmpty()) {
                int g = gcd(stack.get(stack.size() - 1), cur);
                if (g == 1) break;
                cur = lcm(stack.remove(stack.size() - 1), cur); // replace with LCM
            }
            stack.add(cur);
        }
        return stack;
    }
}
