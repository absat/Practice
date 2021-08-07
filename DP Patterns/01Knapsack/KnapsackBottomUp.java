
class KnapsackBottomUp {

    public static void main(String[] args) {
    
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxWeight=7;
    // base checks
    if (maxWeight <= 0 || profits.length == 0 || weights.length != profits.length)
    return;
    int[][] dp = new int[profits.length][maxWeight+1];
    for(int i=0;i<profits.length;i++)
        dp[i][0]=0;
    for(int i=1;i<=maxWeight;i++)
        if(weights[0]<=maxWeight)
            dp[0][i]=profits[0];
    for(int i=1;i<profits.length;i++)
        for(int j=1;j<=maxWeight;j++){
            int profit1=0,profit2=0;
            if(weights[i]<=j)
                profit1=profits[i]+dp[i-1][j-weights[i]];
            profit2 = dp[i-1][j];
            dp[i][j]=Math.max(profit1,profit2);
        }
    int maxProfit = dp[profits.length-1][maxWeight];
    System.out.println("Total knapsack profit ---> " + maxProfit);
    }
  }
  