class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> freqMap = new HashMap<>();

      for(int num: arr){
        freqMap.put(num, freqMap.getOrDefault(num,0)+1);
      }

      int luckyNum = -1;

      for(Map.Entry<Integer, Integer> entry:freqMap.entrySet()){
        int num=entry.getKey();
        int freq = entry.getValue();

        if(num==freq){
            luckyNum=Math.max(luckyNum,num);
        }
      }
      return luckyNum;
    }
}