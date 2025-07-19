class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // 1. Alphabetize the list: Like putting your books in order before deciding which ones to keep
        List<String> result = new ArrayList<>(); // 2. Create an empty list to hold the "keepers" (non-subfolders)
        result.add(folder[0]); // 3. The very first folder is ALWAYS a keeper! Add it to the list

        for (int i = 1; i < folder.length; i++) { // 4. Loop through all the *other* folders (starting from the second one)
            String prev = result.get(result.size() - 1); // 5. Get the last folder we added to the "keepers" list
            String curr = folder[i]; // 6. Get the folder we're currently looking at

            if (!curr.startsWith(prev + "/")) { // 7. The BIG CHECK! Is the *current* folder INSIDE the *previous* folder?

                result.add(curr); // 8. If NOT inside, it's a keeper! Add it to the list
            } // 9. Otherwise, it's a subfolder, and we IGNORE it.
        }

        return result; // 10. Done! Return the list of keepers (non-subfolders)
    }
}