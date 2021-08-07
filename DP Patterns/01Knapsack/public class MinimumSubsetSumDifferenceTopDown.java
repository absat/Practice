class MinimumSubsetSumDifferenceTopDown  {

    public int canPartition(int[] num) {
      int sum1= 0, sum2 =0;
      int sum=0;
      for(int i:num)
        sum+=i;
      Integer[][] dp = new Integer[num.length][sum+1];
      return solve(num,0,sum1,sum2,dp);
    }

    public int solve(int[] num, int index, int sum1, int sum2,Integer[][] dp){
        if(index==num.length)
            return Math.abs(sum1-sum2);
        if(dp[index][sum1]!=null)
            return dp[index][sum2];
        int diff1 = solve(num,index+1,sum1+num[index],sum2,dp);
        int diff2  = solve(num,index+1,sum1,sum2+num[index],dp);
        dp[index][sum1] = Math.min(diff1,diff2);
        return dp[index][sum1];
    } 
    public static void main(String[] args) {
        MinimumSubsetSumDifferenceTopDown ps = new MinimumSubsetSumDifferenceTopDown();
      int[] num = {1, 2, 3, 9};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 3, 100, 4};
      System.out.println(ps.canPartition(num));
    }
  }
 /*
We will be using a two-dimensional array to store the results of the solved sub-problems.
We can uniquely identify a sub-problem from ‘currentIndex’ and ‘Sum1’; as ‘Sum2’ will always be the sum of the remaining numbers.
*/