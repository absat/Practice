class NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] id = new int[n];
        int[] size = new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
            size[i]=1;
        }
        int numOfComponents = n;
        
        for(int[] edge: edges)
            numOfComponents -= union(edge[0],edge[1],id,size);
        
        return numOfComponents;
    }
    public int find(int a, int[] id){
        if(id[a]!=a)
            return find(id[a],id);
        return a;
    }
    public int union(int a, int b, int[] id,int[] size){
        int root1 = find(a,id);
        int root2 = find(b,id);
        
        if(root1==root2)
            return 0;
        
        if(size[root1]>size[root2]){
            size[root1]+=size[root2];
            id[root2] = root1;
        }
        else{
            size[root2]+=size[root1];
            id[root1] = root2;
        }
        return 1;
            
    }
    
    
}