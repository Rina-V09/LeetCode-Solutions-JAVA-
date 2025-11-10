class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < command.length();) {
            if(command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if(command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                sb.append('o');
                i += 2; // Skip both '(' and ')'
            } else if(command.charAt(i) == '(' && command.charAt(i+1) == 'a') {
                sb.append("al");
                i += 4; // Skip '(', 'a', 'l', ')'
            }
        }
        return sb.toString();
    }
}
