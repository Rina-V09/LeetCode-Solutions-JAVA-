class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = smallerOnLeft(heights);
        int[] right = smallerOnRight(heights);
        int max = 0;

        for(int i=0; i<n; i++){
            int currMax = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(max, currMax);
        }
        return max;
    }

    static int[] smallerOnLeft(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    static int[] smallerOnRight(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = n;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }


}