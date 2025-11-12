class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mp.put(t.charAt(i), i);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.abs(i - mp.get(s.charAt(i)));
        }
        return res;
    }
}