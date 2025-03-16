class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Initialize search space for binary search
        long start = Long.MAX_VALUE; // Minimum time to repair cars
        long end = Long.MIN_VALUE; // Maximum time to repair cars
        
        // Find the minimum and maximum rank in the array
        for (int rank : ranks) {
            end = Math.max(end, rank);
            start = Math.min(start, rank);
        }
        
        // Maximum possible time is when the slowest mechanic repairs all cars
        end = end * cars * cars;
        long ans = 0;
        
        // Apply binary search to find the minimum possible repair time
        while (start <= end) {
            long mid = start + (end - start) / 2; // Calculate mid-time
            
            // Check if it is possible to repair all cars within 'mid' time
            if (isCarsRepaired(mid, ranks, cars)) {
                ans = mid; // Store potential answer
                end = mid - 1; // Try to find a smaller valid time
            } else {
                start = mid + 1; // Increase time if not enough cars are repaired
            }
        }

        return ans; // Return the minimum required time
    }

    // Function to check if all cars can be repaired within the given time
    public boolean isCarsRepaired(long time, int ranks[], int carsToBeRepaired) {
        long carsRepaired = 0;
        
        // Calculate the number of cars each mechanic can repair in 'time' duration
        for (int rank : ranks) {
            carsRepaired += (long) (Math.sqrt((1.0 * time) / rank)); // Formula derived from T = rank * n^2
            
            // If the required number of cars is repaired, return true
            if (carsRepaired >= carsToBeRepaired) return true;
        }
        
        // If we can't repair enough cars within 'time', return false
        return false;
    }
}
