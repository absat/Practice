
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right=0;
        int left=1;
        for(int val:piles){
            right = Math.max(val,right);
        }

        while(left<right){
            int mid = left+ (right-left)/2;
            int hours=0;
            for(int pile:piles){
                hours+= Math.ceil((double)pile/mid);
            }

            if(hours<=h)
                right=mid;
            else
                left=mid+1;
        }
        return right;
    }
}
//TC order of log(maxvalueinpile) * pilearraylength
//SC order of 1