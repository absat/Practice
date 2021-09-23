import java.util.*;
class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        
        //min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length,
            new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return a-b;
                }
            });
        
        //sort the intervals  by start time
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(final int[] a, final int[] b){
                return a[0]-b[0];
            }
        });
        
        //add the first meeting
        allocator.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            //If the room due to free up the earliest is free, assign that room to this meeting
            if(intervals[i][0] >= allocator.peek())
                allocator.poll();
            
            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}