class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n=s.length();
        char[] arr = s.toCharArray();

        for(int i=0; i<n; i++){
            if(arr[i]=='('){
                stack.push(')');
            }else if(arr[i]=='{'){
                stack.push('}');
            }else if(arr[i]=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=arr[i])
            return false;
        }

        return stack.isEmpty();

    }
}