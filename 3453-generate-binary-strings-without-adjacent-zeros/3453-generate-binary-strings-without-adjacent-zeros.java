class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();

        String curr = "";
        backTrack(n,curr,ans);
        return ans;
    }

    private void backTrack(int n, String curr, List<String> ans){
        if(curr.length()==n){
            ans.add(curr);
            return;
        }

        backTrack(n,curr+"1", ans);
        if(curr.isEmpty() || curr.charAt(curr.length()-1) != '0'){
            backTrack(n, curr +"0", ans);
        }
    }
}