### Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

```
class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort the array by start times
        //Traverse intervals 1 by 1
        //At each traversal, is start time of interval is greater than end time of last interval, then add the interval to final list
        //Else merge the interval

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        LinkedList<int[]> merged = new LinkedList();

        for(var interval:intervals){
            //non overlapping interval, so add interval to list
            if(merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);
            } else {
                //interval overlap, so adjust end time of merged interval to maximum of both the end times
                merged.getLast()[1] = Math.max(interval[1],merged.getLast()[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```

Time complexity:
O(nlogn), for sorting

Space complexity:
O(n), sorting and also for linkedlist on all intervals non overlapping case.

### Meeting Rooms II
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

```
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //Sort meeting by start times, as we want to assign rooms for meetings chronologically
        //For deciding if to assign or reuse a room, we need to keep track of end times of currently ongoing meetings. So a list.
        //Also we would want to have this list sorted chronologically by end times to help decide if the earliest ending meeting overlaps
        //with the current meeting. We need to add the current meeting's end time to list of ongoing meetings.
        //Before that we do one check to see if the earliest ending meeting ended before the current meeting, if it did, remove that meeting from the list.
        //Finally the size of this list will give the no. of rooms required
        //Since the list has to have the end times in sorted order, we can use a min heap for it

        /**
        Summarizing:
        1. Min heap to store meetings sorted by end time, to let us know when room will be free
        2. Every time check if min element of heap is free
        3. If free remove it from the heap. (decreases heap size, can think of it as room count decreased by 1 for this iteration, as next step we are always adding a new room)
        4. Add the end time of current meeting to heap
        5. Heap size is no of rooms required
         */

        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(final int a[], final int[] b){
                return a[0]-b[0];
            }
        });// or Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> allocatedRooms = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });// or PriorityQueue<Integer> allocatedRooms = new PriorityQueue<Integer>(intervals.length);
        
        allocatedRooms.offer(intervals[0][1]);
        for(int i=1; i<intervals.length;i++){
            if(allocatedRooms.peek()<=intervals[i][0]){
                allocatedRooms.poll();
            }
            allocatedRooms.offer(intervals[i][1]);
        }

        return allocatedRooms.size();
    }
}
```

Time complexity:
O(nlogn), both for sort and min heap operation: In the worst case, all N meetings will collide with each other. In any case we have N add operations on the heap. In the worst case we will have N extract-min operations as well. Overall complexity being (NlogN) since extract-min operation on a heap takes O(logN).

Space complexity:
O(n), worst case n elements are in min-heap