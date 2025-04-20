class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer>[] adj = new LinkedList[n];
        for(int i = 0; i<n;i++){
            adj[i] = new LinkedList<>();
        }
        for(var arr: edges){
            adj[arr[0]].add(arr[1]);
            adj[arr[1]].add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
    
    private boolean dfs(int source, int destination, LinkedList<Integer>[] adj, boolean[] visited){
        if(source == destination)
            return true;
        visited[source] = true;
        Iterator<Integer> i = adj[source].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                if(dfs(n, destination, adj, visited)){//this is important, some paths may not return true,
                    // but we can explore other paths, and the one which returns true we must take that
                    //or another approach is just add a global variable, see simpleSolution below
                    return true;
                }
            }
        }
        return false;
    }
}
/*
 * Simple solution
 * class Solution {
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer>[] adj = new LinkedList[n];
        for(int i = 0; i<n;i++){
            adj[i] = new LinkedList<>();
        }
        for(var arr: edges){
            adj[arr[0]].add(arr[1]);
            adj[arr[1]].add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(source, destination, adj, visited);
        return found;
    }
    
    private void dfs(int source, int destination, LinkedList<Integer>[] adj, boolean[] visited){
        if(source == destination){
            found = true;
            return;
        }
        visited[source] = true;
        Iterator<Integer> i = adj[source].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfs(n, destination, adj, visited);
            }
        }
    }
}
 */