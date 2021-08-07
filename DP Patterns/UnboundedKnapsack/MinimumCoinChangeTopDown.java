class MinimumCoinChangeTopDown {

    public int countChange(int[] denominations, int total) {
      // TODO: Write your code here
      Integer[][] dp = new Integer[denominations.length][total+1];
      int result = solve(denominations,total,0,dp,0);
      return result==Integer.MAX_VALUE?-1:result;
    }
    public int solve(int[] denominations, int total, int index, Integer[][] dp,int sum){
      if(sum==total)
        return 0;
      if(index==denominations.length &&sum!=total)
        return Integer.MAX_VALUE;
      int sum1 = Integer.MAX_VALUE;
      if(dp[index][sum]==null){
        if(sum+denominations[index]<=total){
          int result=solve(denominations,total,index,dp,sum+denominations[index]);
          if(result!=Integer.MAX_VALUE)
            sum1=result+1;
            
        }
        int sum2=solve(denominations,total,index+1,dp,sum);
        dp[index][sum]=Math.min(sum1,sum2);
      }
  
      return dp[index][sum];
    }
  
    public static void main(String[] args) {
        MinimumCoinChangeTopDown cc = new MinimumCoinChangeTopDown();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
  }