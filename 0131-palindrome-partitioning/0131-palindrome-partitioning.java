class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    public void backtrack(String s, int start, List<String> current, List<List<String>> ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start, i+1));
                backtrack(s, i+1,current, ans);
                current.remove(current.size()-1);
            }
        }
    }


    public static boolean isPalindrome(String s, int i, int j){
        int n = s.length();
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}