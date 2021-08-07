class CountOfSubsetSum {

    public int countSubsets(int[] num, int sum) {
      Integer[][] dp = new Integer[num.length][sum + 1];
      return this.countSubsetsRecursive(dp, num, sum, 0);
    }
  
    private int countSubsetsRecursive(Integer[][] dp, int[] num, int sum, int index) {
      // base checks
      if (sum == 0)
        return 1;
  
      if(num.length == 0 || index >= num.length)
        return 0;
  
      // check if we have not already processed a similar problem
      if(dp[index][sum] == null) {
        // recursive call after choosing the number at the currentIndex
        // if the number at currentIndex exceeds the sum, we shouldn't process this
        int sum1 = 0;
        if(sum-num[index]>=0)
            sum1 = countSubsetsRecursive(dp,num,sum-num[index],index+1);
        int sum2 =  countSubsetsRecursive(dp,num,sum,index+1);
        dp[index][sum]=sum1+sum2;
      }
  
      return dp[index][sum];
    }
  
    public static void main(String[] args) {
    CountOfSubsetSum ss = new CountOfSubsetSum();
      int[] num = {1, 1, 2, 3};
      System.out.println(ss.countSubsets(num, 4));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ss.countSubsets(num, 9));
    }
  }