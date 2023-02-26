class longestPalindromeBottomUp {
    public String longestPalindromeBottomUp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max=1;//tricky fo string with no palidrome greater than length 1
        String ans = s.substring(0,1);
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        
        for(int i=s.length()-1;i>=0;i--)
            for(int j=i+1;j<=s.length()-1;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1 || dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        if(j-i+1>max){
                            max=j-i+1;
                            ans = s.substring(i,j+1);
                        }
                    }
                }
            }
        return ans;
    }
}