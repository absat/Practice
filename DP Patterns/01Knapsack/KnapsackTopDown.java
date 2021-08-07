
class KnapsackTopDown {

    public static int knapsackRecursive(int[] profits, int[] weights,int[][] dp, int maxWeight, int index){
        if(maxWeight<=0||index>=profits.length)
            return 0;
            if(dp[index][maxWeight]!=0)
                return dp[index][maxWeight];
        int profit1=0;
        if(weights[index]<=maxWeight)
            profit1 = profits[index]+knapsackRecursive(profits, weights,dp, maxWeight-weights[index], index+1);
        int profit2 = knapsackRecursive(profits, weights, dp,maxWeight, index+1);
        dp[index][maxWeight] = Math.max(profit1,profit2);
        return dp[index][maxWeight];
    }
    public static void main(String[] args) {
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxWeight=7;
    int[][] dp = new int[profits.length][maxWeight+1];
    int maxProfit = knapsackRecursive(profits, weights,dp, 7, 0);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    }
  }
  