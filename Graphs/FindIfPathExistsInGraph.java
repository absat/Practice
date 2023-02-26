import java.util.*;
class FindIfPathExistsInGraph{
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(edges.length==0)
            return true;
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            List<Integer> vadj = new ArrayList<Integer>();
            adj.add(vadj);
        }
        for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.remove();
            Iterator<Integer> itr = adj.get(node).iterator();
            while(itr.hasNext()){
                int next = itr.next();
                if(next==end)
                    return true;
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
                    
            }
        }
        return false;
    }
}