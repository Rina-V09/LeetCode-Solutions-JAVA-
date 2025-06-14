class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();  //Stack to store elements
        int n=s.length;

        for(int i=0; i<n; i++){   //storing each character in stack
            st.push(s[i]);
        }
        for(int i=0; i<n; i++){
           s[i]= st.pop();     //storing the popped element of stack back to s array
        }
    }
}
