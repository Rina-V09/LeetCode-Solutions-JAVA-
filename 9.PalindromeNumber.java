class Solution {
     public boolean isPalindrome(int x) {
         int revNum = 0;
         int copy = x;

         while(x>0){
             int digit = x%10;
             revNum = revNum * 10 + digit;
             x/=10;
         }
         return (copy == revNum);
        
     } }


//Using Recursion
class Solution {
     public boolean isPalindrome(int x) {
        int copy = x;
        if(x<0){
            return false;
        }
        int reversed = revNum(x, 0);
        return (copy == reversed);
    }
    static int revNum(int x, int revNum){
        if (x==0){
            return revNum;
        }
        int digit = x%10;
        revNum = revNum*10 + digit;

        return revNum( x/10,revNum);
    }
}
}
