class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();  
        int m = s2.length();  

        // If s2 is shorter than s1, s1 cannot be a permutation of any substring in s2
        if (m < n) return false;

        // Frequency map for characters in s1
        int map1[] = new int[26];  

       //s1
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }

        // Sliding window over s2 of size n
        for (int i = 0; i <= m - n; i++) {
            // Frequency map for the current window in s2
            int map2[] = new int[26];

            // Build frequency map for the substring s2[i ... i+n-1]
            for (int j = 0; j < n; j++) {
                map2[s2.charAt(i + j) - 'a']++;
            }

            // Compare the two frequency maps
            if (isMatched(map1, map2)) {
                return true;  // Found a permutation of s1 in s2
            }
        }

        // No matching permutation found
        return false;
    }

    // Helper function to compare two frequency maps
    private boolean isMatched(int map1[], int map2[]) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
