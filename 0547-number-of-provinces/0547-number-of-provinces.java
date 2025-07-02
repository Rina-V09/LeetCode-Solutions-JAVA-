class Solution {
    public int findCircleNum(int[][] isConnected) {
      int n=isConnected.length;
      boolean[] vis=new boolean[n];
      int count=0;
      for(int i=0; i<n;i++){
        if(!vis[i]){
            count++;
            dfs(isConnected, i, vis);
        }
      }  
      return count;
    }

    public void dfs(int[][] graph, int src, boolean[] vis){
        vis[src]=true;
        for(int i=0; i<graph[src].length; i++){
            if(graph[src][i]==1 && !vis[i]){
                vis[i]=true;
                dfs(graph,i,vis);
            }
        }
    }
}