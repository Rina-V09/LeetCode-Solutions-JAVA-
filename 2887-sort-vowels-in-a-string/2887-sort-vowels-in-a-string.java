class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        //Sort by ASCII value
        Collections.sort(vowels);

        //Rebuild the string
        StringBuilder result = new StringBuilder();
        int idx = 0;

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;  
    }
}