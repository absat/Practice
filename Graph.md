### Course Schedule, Topological sort

Time complexity:
O(m+n),
m is length of prerequisites(every node, all edges once traversed, leading to m steps total. also for adjList insertion m times executed),

n is courses(queue, n nodes are pushed in total; also for indegree initialization o(n) time)

Space complexity:
adjList = o of m
queue = o of n
indegree = o of n

so again O(m+n)

Code
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();

        //initialize adjList map and indegree map
        for(int i=0;i<numCourses;i++){
            adjList.put(i,new ArrayList<>());
            indegree.put(i,0);
        }

        //traverse prerequisites and fill adjList for prerequisite nodes and indegree for dependent nodes
        for(int[] a:prerequisites){
            indegree.put(a[0], indegree.get(a[0])+1);
            adjList.get(a[1]).add(a[0]);
        }

        //Nodes with 0 indegree  must go into a queue
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry: indegree.entrySet()){
            if(entry.getValue()==0){
                queue.add(entry.getKey());
            }
        }

        //store nodes removed from queue in a courseOrder array
        List<Integer> courseOrder = new ArrayList();

        //1. remove element from head of queue
        //2. add it to courseOrder array
        //3. For all its prerequisites, elements in its adjList, decrease indegree by 1
        //4. If after decreasing indegree, the dependent node has 0 indegree, add it to the queue
        while(!queue.isEmpty()){
            int node = queue.remove();
            courseOrder.add(node);
            for(var child: adjList.get(node)){
                indegree.put(child, indegree.get(child)-1);
                if(indegree.get(child)==0){
                    queue.add(child);
                }
            }
        }

        return courseOrder.size()==numCourses;
    }
}

###Number of Provinces, Union Find
