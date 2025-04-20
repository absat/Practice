import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        if(n==0) return 0;
        int current = 0, prev1 = 0, prev2 = 0;
        for(int i=1;i<heights.length;i++){
            int single = prev2 + Math.abs(heights[i]-heights[i-1]);
            int doubleStep = Integer.MAX_VALUE;
            if(i>1) {
                doubleStep = prev1 + Math.abs(heights[i]-heights[i-2]);
            }
            current = Math.min(single,doubleStep);
            prev1=prev2;
            prev2=current;
        }
        return current;
    }

}