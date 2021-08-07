class CoinChangeBottomUp {

    public int countChange(int[] denominations, int total) {
        int[][] dp = new int[denominations.length][total+1];

        for(int i=0; i < denominations.length; i++)
            dp[i][0] = 1;

        for(int i=0;i<denominations.length;i++){
            for(int j=1;j<=total;j++){
                if(i>0)
                    dp[i][j]=dp[i-1][j];
                if(j>=denominations[i])
                    dp[i][j]+=dp[i][j-denominations[i]];
            }
        }
        return dp[denominations.length-1][total];
    }
  
    public static void main(String[] args) {
    CoinChangeBottomUp cc = new CoinChangeBottomUp();
      int[] denominations = {1, 2, 3};
      System.out.println(cc.countChange(denominations, 5));//5
    }
  }