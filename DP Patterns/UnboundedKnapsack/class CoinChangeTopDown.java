class CoinChangeTopDown {

  public int countChange(int[] denominations, int total) {
    // TODO: Write your code here
    Integer[][] dp = new Integer[denominations.length][total+1];
    return solve(denominations,total,0,dp,0);
  }
  public int solve(int[] denominations, int total, int index, Integer[][] dp,int sum){
    if(sum==total)
      return 1;
    if(index==denominations.length &&sum!=total)
      return 0;
    int sum1 = 0,sum2 = 0;
    if(dp[index][sum]==null){
      if(sum+denominations[index]<=total){
        sum1=solve(denominations,total,index,dp,sum+denominations[index]);
      }
      sum2=solve(denominations,total,index+1,dp,sum);
      dp[index][sum]=sum1+sum2;
    }

    return dp[index][sum];
  }

  public static void main(String[] args) {
    CoinChangeTopDown cc = new CoinChangeTopDown();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));//5
  }
}