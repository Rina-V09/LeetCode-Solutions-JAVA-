class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
         int v=graph.length;
         Stack<Integer> path=new Stack<>();
         path.add(0);
         solve(graph,0,path);
         return ans;
    }

    public void solve(int[][] graph , int src , Stack<Integer> path){
           if(src== (graph.length-1)){
                 ans.add( new ArrayList<>(path) );
                 return;
           }
           for(int neigh:graph[src]){
                path.push(neigh);
                solve(graph,neigh,path);
                //backtrack
                path.pop();
           }
    }
}