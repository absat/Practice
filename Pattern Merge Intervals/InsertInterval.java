class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx=0, n=intervals.length;
        ArrayList<int[]> list = new ArrayList();
        while(idx<n && intervals[idx][1]<newStart)
            list.add(intervals[idx++]);
        
        int[] interval = new int[2];
        while(idx<n&&intervals[idx][0]<=newEnd){
            newStart = Math.min(newStart,intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }
        list.add(new int[]{newStart,newEnd});
        while(idx<n)
            list.add(intervals[idx++]);
        
        return list.toArray(new int[list.size()][]);
    }
}
//TC O(N)
//SC O(N)