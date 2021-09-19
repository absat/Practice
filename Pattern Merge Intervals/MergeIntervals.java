class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> mergeList = new LinkedList();
        for(int[] interval: intervals){
            if(mergeList.isEmpty()||mergeList.getLast()[1]<interval[0]){
                mergeList.add(interval);
            }
            else{
                mergeList.getLast()[1]=Math.max(mergeList.getLast()[1],interval[1]);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
//TC O(NlogN)
//SC O(N) (Sorting Java- Timsort)