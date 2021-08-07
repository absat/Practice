class MinimumPathSum1 {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return solve(0,0,grid,dp);
    }
    public int solve(int x,int y,int[][] grid,Integer[][] dp){
        if(x==grid.length||y==grid[0].length)
            return Integer.MAX_VALUE;
        if(dp[x][y]!=null)
            return dp[x][y];
        if(x==grid.length-1&&y==grid[0].length-1){
            dp[x][y]= grid[x][y]; 
            return dp[x][y];
        }
            
        dp[x][y]=grid[x][y]+Math.min(solve(x+1,y,grid,dp),solve(x,y+1,grid,dp));
        return dp[x][y];
            
    }
}
//T O(MN)
//S O(MN)

//Without memo T: O(2^(m+n))
//             S: O(M+N), recursion depth