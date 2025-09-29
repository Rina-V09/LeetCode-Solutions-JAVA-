class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int depth = 0;
        StringBuilder sb = new StringBuilder();

         for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) sb.append(ch); 
                depth++;
            } else if (ch == ')') {
                depth--;
                if (depth > 0) sb.append(ch); 
            }
        }

        return sb.toString();
    }
}