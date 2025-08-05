class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for(int i=0; i<n; i++){
            int j=0;
            boolean placed = false;

            while(j<n){
                if(!used[j] && baskets[j]>=fruits[i]){
                    used[j] = true;
                    placed = true;
                    break;
                }
                j++;
            }

            if(!placed){
                unplaced++;
            }
        }
        return unplaced;
    }
}