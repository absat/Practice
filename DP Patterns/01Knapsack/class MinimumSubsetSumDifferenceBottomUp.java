class MinimumSubsetSumDifferenceBottomUp  {

    public int canPartition(int[] num) {

      int sum=0;
      for(int i:num)
        sum+=i;
      int halfSum = sum/2;
      boolean [][] dp = new boolean[num.length][halfSum+1];

      for(int i=0;i<num.length;i++)
        dp[i][0]=true;

      for(int i=1;i<halfSum+1;i++){
          if(num[0]==i)
          dp[0][i]=true;
      }
     
      for(int i=1;i<num.length;i++){
          for(int j=1;j<halfSum+1;j++){
              if(dp[i-1][j])
                dp[i][j] = true;
              else{
                  if(j>=num[i])
                  dp[i][j] = dp[i-1][j-num[i]];
              }
          }
      }
      int sum1=0;
      for(int i=halfSum;i>=0;i--){
          if(dp[num.length-1][i]){
            sum1=i;
            break;
          }
      }

      return Math.abs(sum1-(sum-sum1));

    } 
    public static void main(String[] args) {
        MinimumSubsetSumDifferenceBottomUp ps = new MinimumSubsetSumDifferenceBottomUp();
      int[] num = {1, 2, 3, 9};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 3, 100, 4};
      System.out.println(ps.canPartition(num));
    }
  }
  /*
  We will treat it as a problem of equal subset, with the change that we will look for sum close to s/2
  Then for getting the final sum we will traverse last row of table
  Dont forget break inthis last traversal
  */


  /*From educative
Bottom-up Dynamic Programming #
Let’s assume ‘S’ represents the total sum of all the numbers. So what we are trying to achieve in this problem is to find a subset whose sum is as close to ‘S/2’ as possible, because if we can partition the given set into two subsets of an equal sum, we get the minimum difference i.e. zero. This transforms our problem to Subset Sum, where we try to find a subset whose sum is equal to a given number-- ‘S/2’ in our case. If we can’t find such a subset, then we will take the subset which has the sum closest to ‘S/2’. This is easily possible, as we will be calculating all possible sums with every subset.

Essentially, we need to calculate all the possible sums up to ‘S/2’ for all numbers. So how do we populate the array db[TotalNumbers][S/2+1] in the bottom-up fashion?

For every possible sum ‘s’ (where 0 <= s <= S/2), we have two options:

Exclude the number. In this case, we will see if we can get the sum ‘s’ from the subset excluding this number => dp[index-1][s]
Include the number if its value is not more than ‘s’. In this case, we will see if we can find a subset to get the remaining sum => dp[index-1][s-num[index]]
If either of the two above scenarios is true, we can find a subset with a sum equal to ‘s’. We should dig into this before we can learn how to find the closest subset.

Let’s draw this visually, with the example input {1, 2, 3, 9}. Since the total sum is ‘15’, therefore, we will try to find a subset whose sum is equal to the half of it i.e. ‘7’.
  */