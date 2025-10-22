class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[target+1][n+1];
        int ways=0;
        for(int i=1;i<=target;i++){
            if(i<=k)
            dp[i][1]=1;
        }

        for(int i=1;i<=target;i++){
            for(int j=2;j<=n;j++){
                int sum=0;
                for(int l=1;l<=k;l++){
                    if(i-l>=0){
                        sum=(sum+dp[i-l][j-1])%1000000007;
                    }
                }
                dp[i][j]=sum%1000000007;
            }
        }

        return dp[target][n];
    }
}