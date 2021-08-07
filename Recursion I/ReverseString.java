//Below using recursion
//Time complexity : O(N) time to perform N/2 swaps.
//Space complexity : O(N) to keep the recursion stack.
class Solution {
    public void helper(char[] s, int left, int right){
        if(left>=right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
        helper(s,left,right);
    }
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
}
//Below using two pointer, O(1) SPACE   
/*class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}*/