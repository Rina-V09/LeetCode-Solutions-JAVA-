class Solution {
    public int maximum69Number (int num) {
        // Convert the integer to a string to easily access and manipulate individual digits.
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();

        // Iterate through the characters (digits) from left to right.
        for (int i = 0; i < charArray.length; i++) {
            // Find the first occurrence of '6'.
            if (charArray[i] == '6') {
                // Change the first '6' to a '9'.
                charArray[i] = '9';
                // Break the loop as we only need to change at most one digit.
                break;
            }
        }
        
        // Convert the modified character array back to a string and then to an integer.
        return Integer.parseInt(new String(charArray));
    }
}