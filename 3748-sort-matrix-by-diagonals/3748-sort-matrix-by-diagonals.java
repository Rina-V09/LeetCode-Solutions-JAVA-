import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        //Sort 
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (key >= 0) {
                list.sort(Collections.reverseOrder()); // des
            } else {
                Collections.sort(list); // asc
            }
        }

        // Place back elements
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int idx = index.getOrDefault(key, 0);
                grid[i][j] = map.get(key).get(idx);
                index.put(key, idx + 1);
            }
        }

        return grid;
    }
}
