import java.util.*;
class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n= graph.length;
        List<List<Integer>> ans = new ArrayList();
        if(n==0)
            return ans;
        List<Integer> path = new ArrayList<Integer>();
        dfs(n,graph,0,ans,path);
        return ans;
    }
    public void dfs(int n,int[][] graph, int node, List<List<Integer>> ans, List<Integer> path){
        path.add(node);
        if(node==n-1)
        {
            ans.add(new ArrayList<Integer>(path));// VVIMP
            path.remove(new Integer(node));
            return;
        }
        for(int i=0;i<graph[node].length;i++){
            int neighbnode = graph[node][i];
                dfs(n,graph,neighbnode,ans,path);
        }
        path.remove(new Integer(node));
        return;
    }
}