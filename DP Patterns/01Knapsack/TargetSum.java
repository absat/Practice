/**
 * If you are following educative, caution! their solution doesnt work for element 0
 * Read comments at bottom but only after giving a try at the problem, bottom part has sln
 */
class TargetSum {

  public int findTargetSubsets(int[] nums, int target) {
    int sum = 0;
    for(int i: nums)
        sum+=i;
    if(target>sum||-sum>-target||(sum+target)%2!=0)
        return 0;
    int[] dp = new int[(sum+target)/2+1];
    dp[0]=1;

    for(int num:nums)
    {
        for(int j=dp.length-1;j>=num;j--){
                dp[j]+=dp[j-num];
        }
    }
    return dp[dp.length-1];
   }

    public static void main(String[] args) {
        TargetSum ss = new TargetSum();
      int[] num = {0,0,1};
      System.out.println(ss.findTargetSubsets(num, 1));
      num = new int[]{1, 2, 7, 1};
      System.out.println(ss.findTargetSubsets(num, 9));
    }
}
/*
Educative works only for positive numbers, this is my leetcode solution for all whole numbers
lets say 1,3,3,4 target=1
s1 = 3 + 3
s2= 1 + 4

so s1-s2=target
but s1 + s2 =sum
so s1-target= sum -s1
so s1 = (sum + target)/2


1 pass solution: we are working repeatedly on same columns for different rows, hence optimised, 
imp: right to left traversal as l2r will not allow the required updates
 */