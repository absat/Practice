class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        HashMap<Integer,Integer> indegree = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            adjList.put(i, new ArrayList<>());
            indegree.put(i,0);
        }

        for(int[] arr: prerequisites){
            indegree.put(arr[0],indegree.get(arr[0])+1);
            adjList.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[numCourses];
        int index=0;
        for(Map.Entry<Integer,Integer> entry:indegree.entrySet()){
            if(entry.getValue()==0)
                q.add(entry.getKey());
        }

        while(!q.isEmpty()){
            int x= q.remove();
            answer[index++]=x;
            for(var children: adjList.get(x)){
                indegree.put(children, indegree.get(children)-1);
                if(indegree.get(children)==0){
                    q.add(children);
                }
            }
        }

        if(index!=numCourses)
            return new int[0];

        return answer;
    }
}

/*
 * tc order of v+ e, v for each node, e for each edge
 * sc order of v + e, v if all indegree 0 so q has v elements, also e for edges to store in adj list
 */