class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[3]; // Array to store frequency of 'a', 'b', and 'c'
        int count = 0; // Variable to count valid substrings
        int curCount = 0; // To track unique characters in the current window
        int left = 0; // Left pointer of the sliding window
        int n = s.length(); // Length of the input string

        // Traverse the string using the right pointer
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right); // Get the current character
            freq[ch - 'a']++; // Increment the frequency of the character
            
            // If this character appears for the first time in the window, increase curCount
            if (freq[ch - 'a'] == 1) {
                curCount++;
            }

            // When all three characters ('a', 'b', 'c') are present in the window
            while (curCount == 3) {
                count += (n - right); // Add valid substrings ending at 'right'

                // Shrink the window from the left
                char c = s.charAt(left);
                freq[c - 'a']--; // Reduce frequency of the leftmost character
                
                // If removing a character makes it disappear from the window, decrease curCount
                if (freq[c - 'a'] == 0) {
                    curCount--;
                }
                left++; // Move left pointer forward
            }
        }
        return count; // Return total count of valid substrings
    }
}
