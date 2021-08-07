public class UnionFind {
    
    // The number of elements in this union find
    private int size;

    // Used to track the sizes of each component
    private int[] sz;

    // id[i] points to the parent of i, if id[i]=i then i is a root node
    private int[] id;

    // Tracks the no. of component in the union find
    private int numComponents;

    public UnionFind(int size){
        if(size<=0)
        throw new IllegalArgumentException("Size <= 0 is not allowed");

        this.size = numComponents = size;

        sz = new int[size];
        id = new int[size];

        for(int i=0;i<size;i++){
            id[i]=i; // Link to itself (self root)
            sz[i]=1;
        }
    }

    // Find which component/set 'p' belongs to, takes amortized constant time.
    public int find(int p){

        // Find the root of the set/component
        int root=p;
        while(root!=id[root])
        root = id[root];

        // Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized time complexity
        while(p!=root){
            int next=id[p];
            id[p]=root;
            p=next;
        }

        return root;
    }

    // Return whether or not the elements 'p' and 'q' are in the same component
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // Return the size of the component 'p' belongs to
    public int componentSize(int p){
        // root nodes are the ones that hold size, since they
        // are the last to be found
        return sz[find(p)];
    }

    // Returns the number of elements in the Union Find/Disjoint Set
    public int size(){
        return size;
    }

    //Returns the number of remaining components
    public int components(){
        return numComponents;
    }

    // Unify the components/sets containing elements 'p' & 'q'
    public void unify(int p,int q){
        int root1 = find(p);
        int root2 = find(q);

        // These are already in the same grp
        if(root1==root2)
            return;
        
        // Merge two components together, mergeg smaller grp to larger grp
        // Some people prefer to keep theoretical largest path in component and merge according that, 
        // its implementation is more complex
        if(sz[root1]>sz[root2]){
            sz[root1]+=sz[root2];
            id[root2]=root1;
        }
        else{
            sz[root2]+=sz[root1];
            id[root1]=root2;
        }

        // Since a grp is merged, num of componenents decreases by 1
        numComponents--;
    }
}
