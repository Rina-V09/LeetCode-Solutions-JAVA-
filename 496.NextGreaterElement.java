class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int x:nums2){
            while(!stack.isEmpty() && stack.peek()<x){
                map.put(stack.pop(),x);
            }
            stack.push(x);
        }

        //remaining stack element have no greater, map to -1
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        //build result for nums1
        int arr[]= new int[nums1.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=map.get(nums1[i]);
        }
        return arr;
    }
}
