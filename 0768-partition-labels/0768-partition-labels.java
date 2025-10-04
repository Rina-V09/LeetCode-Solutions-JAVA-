class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastOcc = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            lastOcc.put(s.charAt(i),i);
        }

        List<Integer> ans = new ArrayList<>();
        int prev = -1, max = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            max = Math.max(max,lastOcc.get(ch));
            if(max==i){
                ans.add(max-prev);
                prev = max;
            }
        }
        return ans;
    }
}