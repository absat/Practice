class Solution {
public int longestPalindromeSubseq(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return solve(s,dp,0,s.length()-1);
    }
    int solve(String s, Integer[][] dp, int startIndex, int endIndex){
        if(startIndex>endIndex)
            return 0;
        if(startIndex==endIndex)
            return 1;
        if(dp[startIndex][endIndex]==null){
            if(s.charAt(startIndex)==s.charAt(endIndex))
                dp[startIndex][endIndex] = 2 + solve(s,dp,startIndex+1,endIndex-1);
            else{
                int c1 = solve(s,dp,startIndex+1,endIndex);
                int c2 = solve(s,dp,startIndex,endIndex-1);
                dp[startIndex][endIndex] = Math.max(c1,c2);
            }
        }
        return dp[startIndex][endIndex];
    }
};