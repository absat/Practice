import java.util.*;
class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list =new ArrayList<Integer>();
            adj.add(list);
        }
        for(int[] pair: edges){
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }
        boolean[] visited= new boolean[n]; 
        return dfs(adj,start,end,visited);
    }
    boolean dfs(List<List<Integer>> adj,int start, int end, boolean[] visited){
        if(start==end)
            return true;
        Iterator<Integer> i = adj.get(start).iterator();
        visited[start]=true;
        while(i.hasNext()){
            int node = i.next();
            if(!visited[node]){
                if(dfs(adj,node,end,visited))
                    return true;
            }
        }
        return false;
    }
}