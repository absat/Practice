class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count=0;
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
            count++;
        }
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i+1;j<=s.length()-1;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1 || dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        return count;
    }
}