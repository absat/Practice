import java.util.*;

class CompilationOrder {
    public static String repeat(String str, int pValue){
        String out = "";
        for(int i = 0; i < pValue; i++)
        {
            out += str;
        }
        return out;
    }
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies){
        List<Character> sortedOrder = new ArrayList<>();
        HashMap<Character,List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(int i=0;i<dependencies.size();i++){
            graph.put(dependencies.get(i).get(0),new ArrayList<>());
            graph.put(dependencies.get(i).get(1),new ArrayList<>());
            indegree.put(dependencies.get(i).get(0),0);
            indegree.put(dependencies.get(i).get(1),0);
            
        }
        if(graph.size()==0)
            return sortedOrder;

        for(int i=0;i<dependencies.size();i++){
            graph.get(dependencies.get(i).get(1)).add(dependencies.get(i).get(0));
            indegree.put(dependencies.get(i).get(0),indegree.get(dependencies.get(i).get(0))+1);
        }

        Queue<Character> queue = new LinkedList<>();
        for(char key:indegree.keySet()){
            if(indegree.get(key)==0)
                queue.add(key);

        }

        while(!queue.isEmpty()){
            Character subject =  queue.poll();
            sortedOrder.add(subject);
            List<Character> children = graph.get(subject);
            for(Character c:children){
                indegree.put(c,indegree.get(c)-1);
                if(indegree.get(c)==0){
                    queue.add(c);
                }
            }
        }
        if(sortedOrder.size()!=graph.size())
            return new ArrayList<>();
        return sortedOrder;
       
    }
    public static void main( String args[] ) {
        List<List<List<Character>>> inputs = Arrays.asList(
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'),Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
            Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
            Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
            Arrays.asList(Arrays.asList('C', 'C'))
        );
          ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>();
    for(int j = 0; j < inputs.size(); j++)
    {
      dependencies.add(new ArrayList<ArrayList<Character>>());
      for(int k = 0; k < inputs.get(j).size(); k++)
      {
        dependencies.get(j).add(new ArrayList<Character>());
        for(int g = 0; g < inputs.get(j).get(k).size(); g++)
        {
          dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
        }
      }
    }
        for(int i = 0; i < dependencies.size(); i++)
        {
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(repeat("-", 100));
        }
    }
}

//T.C.Time complexity o v+e
//S.C. O(V), deque data str is sed which will have o(v) elem in worst case, also hash table is o(v) as well