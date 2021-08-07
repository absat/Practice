class CountOfSubsetSumBottomUp {

    public int countSubsets(int[] num, int sum) {
      int[][] dp = new int[num.length][sum + 1];

      for(int i=0;i<num.length;i++)
        dp[i][0]=1;

      for(int i=1;i<sum+1;i++){
          if(num[0]==i)
          dp[0][i]=i;
      }

      for(int i=1;i<num.length;i++){
          for(int j=1;j<sum+1;j++){
              dp[i][j] = dp[i-1][j];
              if(j-num[i]>=0)
              dp[i][j] += dp[i-1][j-num[i]];
          }
      }
      return dp[num.length-1][sum];  
     }
    public static void main(String[] args) {
    CountOfSubsetSumBottomUp ss = new CountOfSubsetSumBottomUp();
      int[] num = {1, 1, 2, 3};
      System.out.println(ss.countSubsets(num, 4));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ss.countSubsets(num, 9));
    }
  }