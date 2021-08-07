class UnboundedKnapsackTopDown {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      Integer[][] dp = new Integer[profits.length][capacity+1];
      return solve(profits,weights,capacity,0,dp);
    }
  
    public int solve(int[] profits, int[] weights, int capacity,int index,Integer[][] dp)
    {
      if(profits.length==0||index==profits.length||capacity==0)
        return 0;
      if(dp[index][capacity]==null){
      int set1 = 0;
      if(capacity-weights[index]>=0)
        set1 = profits[index]+solve(profits,weights,capacity-weights[index],index,dp);
      int set2 = solve(profits,weights,capacity, index+1,dp);
      dp[index][capacity] = Math.max(set1,set2);
      }
      return dp[index][capacity];
    }
  
    public static void main(String[] args) {
        UnboundedKnapsackTopDown ks = new UnboundedKnapsackTopDown();
      int[] profits = { 15, 50, 60, 90 };
      int[] weights = { 1, 3, 4, 5 };
      int maxProfit = ks.solveKnapsack(profits, weights, 10);
      System.out.println(maxProfit);
    }
  }
  //Time: O(N*C)
  //Space: O(N*C+N)=O(N*C), N for recusion stack