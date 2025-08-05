class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> basket = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxFruit = 0;

        for(right = 0; right<fruits.length; right++){
            int currCount = basket.getOrDefault(fruits[right],0);
            basket.put(fruits[right], currCount+1);

            while(basket.size()>2){
                int fruitCount = basket.get(fruits[left]);

                if(fruitCount == 1){
                    basket.remove(fruits[left]);
                }
                else{
                    basket.put(fruits[left],fruitCount-1);
                }
                left++;
            }
            maxFruit = Math.max(maxFruit, right-left+1);
        }
        return maxFruit;
    }
}