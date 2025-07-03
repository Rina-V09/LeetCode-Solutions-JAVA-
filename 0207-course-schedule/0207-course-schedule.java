class Solution {
    public boolean canFinish(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            graph.get(src).add(dest);
        }
        
        boolean[] vis = new boolean[v];
        boolean[] path = new boolean[v];
        
        for(int i=0; i<v; i++){
            if(!vis[i]){
                if(check(graph, vis, path, i)) return false;
            }
        }
        return true;
    }
    
    public boolean check(List<List<Integer>> graph, boolean[] vis, boolean[] path, int src){
        vis[src]=true;
        path[src]=true;
        
        for(int neighbor : graph.get(src)){
            if(!vis[neighbor]){
                if(check(graph, vis, path, neighbor))
                    return true;
            }else if(path[neighbor]){
                return true;    //  back edge found
            }
        }
        
        path[src]=false; //Backtrack
        return false;
    }
}