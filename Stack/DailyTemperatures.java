class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int currDay=0;currDay<n;currDay++){
            int currentTemp = temperatures[currDay];
            while(!stack.isEmpty() && currentTemp>temperatures[stack.peek()]){
                int prevDay = stack.pop();
                answer[prevDay] = currDay-prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }
}
/*
Time complexity: O(N)

At first glance, it may look like the time complexity of this algorithm should be O(n^2)
 because there is a nested while loop inside the for loop. However, each element can only be added to the stack once, which means the stack is limited to NNN pops. Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than NNN times in total, across all iterations of the for loop.

An easier way to think about this is that in the worst case, every element will be pushed and popped once. This gives a time complexity of O(2⋅N)=O(N)

Space complexity: O(N)

If the input was non-increasing, then no element would ever be popped from the stack, and the stack would grow to a size of N elements at the end.
*/