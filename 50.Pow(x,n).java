class Solution {
    public double myPow(double x, int n) {
        if(n==0)
        return 1;
        long p=n;
        if(p<0)
        {
          p=-p;
          x=1/x; 
        }

        if(p%2==0)
        return myPow(x*x,(int)(p/2));
        else
        return x*myPow(x,(int)(p-1));
    }
}
