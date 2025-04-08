class Solution {
    public int minimumOperations(int[] nums) {
        // Create a frequency array to track occurrences of numbers from 0 to 100
        int hashmap[] = new int[101]; 
        
        // This will store the index from the end where a duplicate is found
        int lastindex = 0;

        // Traverse the array from the end to the beginning
        for (int i = nums.length - 1; i >= 0; i--) {
            // If the current number has already appeared, mark the position
            if (hashmap[nums[i]] > 0) {
                // Set the lastindex to one position after the duplicate
                lastindex = i + 1;
                break; // Stop the loop as we found the first duplicate from end
            }
            // Mark this number as seen
            hashmap[nums[i]]++;
        }

        // If lastindex is divisible by 3 exactly, return the quotient
        if (lastindex % 3 == 0) {
            return lastindex / 3;
        }

        // Else return the ceiling value of (lastindex / 3)
        // i.e., we need one more operation to cover the remaining elements
        return lastindex / 3 + 1;
    }
}
