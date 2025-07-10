class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,0,0,target, new Stack<Integer>());
        return ans;
    }

    public void solve(int arr[], int i,int sum,int target, Stack<Integer> st){
        if(sum>target || i>=arr.length) 
        return;

        if(sum==target){
            ans.add(new ArrayList<>(st));
            return;
        }

        //take
        st.push(arr[i]);
        solve(arr,i,sum+arr[i], target, st);
        st.pop();
        //skip
        solve(arr, i+1, sum, target, st);
    }
}