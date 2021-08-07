import java.util.*;
class MergeKSortedLists{
    private static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    private static void solve(List<List<Integer>> sortedArrays){
        List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer>>(sortedArrays.size());
        for(int i=0;i<sortedArrays.size();i++)
            iters.add(sortedArrays.get(i).iterator());

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((int)sortedArrays.size(),new Comparator<ArrayEntry>(){
            @Override
            public int compare(ArrayEntry o1,ArrayEntry o2){
                 return Integer.compare(o1.value, o2.value);
            }
        });
        
        for(int i =0; i < iters.size(); i++){
            if(iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if(iters.get(headEntry.arrayId).hasNext())
                minHeap.add( new ArrayEntry(
                    iters.get(headEntry.arrayId).next(), headEntry.arrayId));
        }

        for(int r: result)
            System.out.print(r+" ");
        
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);a.add(9);
        List<Integer> b = new ArrayList<Integer>();
        b.add(5);b.add(6);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(a);
        list.add(b);

        solve(list);
    }
}