class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store groups
        // Key   = sorted version of a string
        // Value = list of strings (anagrams)
        Map<String, List<String>> map = new HashMap<>();

        // Process each string in the input
        for (String str : strs) {
            // Convert string to char array to sort letters
            char[] charArray = str.toCharArray();

            // Sort the characters alphabetically
            Arrays.sort(charArray);

            // Rebuild the sorted string (this is our "key")
            String sortedStr = new String(charArray);

            // If this key is not already in the map, create a new list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            // Add the original string to the group belonging to its sorted key
            map.get(sortedStr).add(str);
        }

        // Collect all groups (values of the map) and return as a list of lists
        return new ArrayList<>(map.values());
    }
}
