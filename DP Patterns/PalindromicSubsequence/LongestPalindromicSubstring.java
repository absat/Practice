class Solution {
    public String longestPalindrome(String s) {
     if(s.length() == 1){return s;}
     
     String[][] dp = new String[s.length()][s.length()];
     return util(s,0,s.length() - 1,dp);
 }
 
 String util(String s,int start,int end,String[][] dp){
     if(start > end){return "";}
     if(dp[start][end] != null){return dp[start][end];}
     
     /**
     * Only checking if it's a palindrome if the start and end characters of the substring 
     * are equal
     **/
     if(s.charAt(start) == s.charAt(end) && isPalindrome(s,start + 1,end - 1)){
         return dp[start][end]=s.substring(start, end + 1);
     }
     /**
     * Names are based on the direction the substring will be moving to
     **/
     String right = util(s,start + 1,end,dp);
     String left = util(s,start,end - 1,dp);
     
     return dp[start][end] = right.length() > left.length()?right:left;
 }
 
 boolean isPalindrome(String s,int start,int end){
     while(start < end){
         if(s.charAt(start++) != s.charAt(end--)){return false;}
     }
     return true;
 }

}