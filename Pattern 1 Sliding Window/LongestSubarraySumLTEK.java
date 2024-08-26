import java.util .*;
class LongestSubarraySumLTEK {
    public static void main(String[] args){
        int[] arr = {3,2,1,3,1,1};
        int k=5;
        solve(arr,k);
    }

    static void solve(int[] arr, int k){
        int left = 0;
        int right=0;
        int maxLength = 0, sum =0;
        for(right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        System.out.println(maxLength);
    }
}
