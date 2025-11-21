class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        for(char ch='a'; ch<='z'; ch++){
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if(first!=-1 && last != -1 && first < last){
                HashSet<Character> middle = new HashSet<>();

                for(int i=first+1; i<last; i++){
                    middle.add(s.charAt(i));
                }
                result += middle.size();
            }
        }
        return result;
    }
}