class RodCutting {

    public int solveRodCutting(int[] lengths, int[] prices, int n) {
      int[][] dp = new int[lengths.length][n+1];
      for(int i = 0; i<lengths.length;i++){
          for(int j=1;j<=n;j++){
              int price1=0,price2=0;
              if(lengths[i]<=j)
                price1 = prices[i]+dp[i][j-lengths[i]];
              if(i>0)
                price2 = dp[i-1][j];
              dp[i][j] = Math.max(price1,price2);
          }
      }
      return dp[lengths.length-1][n];
    }
  
    public static void main(String[] args) {
      RodCutting rc = new RodCutting();
      int[] lengths = {1, 2, 3, 4, 5};
      int[] prices = {2, 6, 7, 10, 13};
      int maxProfit = rc.solveRodCutting(lengths, prices, 5);
      System.out.println(maxProfit);
    }
  }
  //O(L*N)
  