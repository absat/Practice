class MinimumPathSum2{
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1&&j!=grid[0].length-1)
                    dp[j] = grid[i][j]+dp[j+1];
                else if(i!=grid.length-1&&j==grid[0].length-1)
                    dp[j] = grid[i][j]+dp[j];
                else if(i!=grid.length-1&&j!=grid[0].length-1)
                    dp[j] = grid[i][j]+Math.min(dp[j+1],dp[j]);
                else
                    dp[j]=grid[i][j];
            }
        }
        return dp[0];
    }
}
//Poor runtime than memo recursion in leetcode, but space O(M)
//Time same O(MN)

//Even more optimized, modify array in place, O(1) Space