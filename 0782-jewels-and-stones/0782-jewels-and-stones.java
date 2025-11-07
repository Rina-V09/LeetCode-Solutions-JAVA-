class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        for(char ch : jewels.toCharArray()){
            set.add(ch);
        }

        int count = 0;
        for(char c : stones.toCharArray()){
            if(set.contains(c)) count++;
        }
        return count;
    }
}