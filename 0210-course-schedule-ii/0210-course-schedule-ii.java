class Solution {
    public static List<List<Integer>>  build(int v,int[][] edges){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge :edges){
            int src=edge[0];
            int dest=edge[1];
            adj.get(src).add(dest);
        }
        return adj;
    }
    public int[] findOrder(int v, int[][] edges) {
        List<List<Integer>> adj=build(v,edges);
        int indegree[]=new int[v];
        //indegree
        for(int i=0;i<v;i++){
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[]=new int[v];
        int i=0;
        while(!q.isEmpty()){
            int node=q.remove();
            topo[i++]=node;
        

        for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }
        }
        }
        int left=0;
        int right=v-1;
        while(left<right){
            int temp=topo[left];
            topo[left]=topo[right];
            topo[right]=temp;
            left++;
            right--;
        }
        //cycledetection
        if(i!=v){
            return new int[0];
        }
    return topo;
    }
}