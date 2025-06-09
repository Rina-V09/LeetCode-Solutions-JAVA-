class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            if(ans<Integer.MIN_VALUE/10||ans>Integer.MAX_VALUE/10){ //ans should be between provided constraints
                return 0;
            }
        //    int rem=x%10;
        //     rev=x*10+rem;
        //     x=x/10;
        ans=ans*10+x%10;
        x=x/10;
        }
        return ans;
        
    }
}
