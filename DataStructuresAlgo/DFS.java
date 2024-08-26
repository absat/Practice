package DataStructuresAlgo;

import java.util.*;

public class DFS {
    private int V;

    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public DFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i =0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]){
        //Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        //Recurse for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    void doDFS(int startingNode){
        boolean visited[] = new boolean[V];
        DFSUtil(startingNode, visited);
    }

    public static void main(String[] args){
        DFS dfs = new DFS(6);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 0);
        dfs.addEdge(1, 4);
        dfs.addEdge(1, 5);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 4);
        dfs.addEdge(3, 0);
        dfs.addEdge(3, 4);
        dfs.addEdge(4, 1);
        dfs.addEdge(4, 2);
        dfs.addEdge(4, 3);
        dfs.addEdge(4, 5);
        dfs.addEdge(5, 1);
        dfs.addEdge(5, 4);
        dfs.doDFS(0);
        System.out.println();

        dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        dfs.doDFS(2);

    }
}
