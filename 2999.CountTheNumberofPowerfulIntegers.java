class Solution {
    private long solve(String str, String suffix, int limit){
        //IF THE NUMBER IS SHORTER THAN THE SUFFIX, IT CANT END WITH SUFFIX
        if(str.length()<suffix.length()){
            return 0;
        }

        long count=0;
        int prefixLength = str.length()-suffix.length();
        String trailing = str.substring(prefixLength); //Suffix part of str

        //count valid combinations for prefix digits
        for(int i=0;i<prefixLength;i++){
            int digit=str.charAt(i)-'0';

            if(digit<=limit){
                count+=digit*Math.pow(limit+1, prefixLength-i-1);
            }else{
                count+=Math.pow(limit+1, prefixLength-i);
                return count;
            }
        }

        //If the suffix in str is >= required suffix, count it
        if(trailing.compareTo(suffix)>=0){
            count++;
        }return count;
    }
    public long numberOfPowerfulInt(long start,long finish,int limit, String s) {
        String startStr=String.valueOf(start-1);
        String finishStr=String.valueOf(finish);

        return solve(finishStr, s, limit)-solve(startStr,s, limit);
        
}}
