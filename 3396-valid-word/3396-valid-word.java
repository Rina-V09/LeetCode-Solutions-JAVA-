class Solution {
    public boolean isValid(String word) {
        int n=word.length();
        boolean hasVowel = false;
        boolean hasConsonant = false;

        if(n<3)
        return false;

        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if("aeiouAEIOU".indexOf(ch)!=-1){
                hasVowel= true;
            }else if(Character.isLetter(ch)){
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }
}