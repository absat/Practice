class UnboundedKnapsackBottomUp {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      int[][] dp = new int[profits.length][capacity+1];

      for(int i = 0 ;i < profits.length; i++){
        for(int j=1;j<=capacity;j++){
            int profit1 = 0, profit2 = 0;
            if(weights[i]<=j)
                profit1= profits[i] + dp[i][j-weights[i]];
            if(i>0){
                profit2= dp[i-1][j];
            }
            dp[i][j] = Math.max(profit1,profit2);
        }
      }
      //Section for printing weights of selected elements
      System.out.println("Elements: ");
      int totalProfit = dp[profits.length-1][capacity],weight=capacity;
      for(int i=profits.length-1;i>0;i--){
        if(dp[i-1][weight]!=totalProfit){
            totalProfit -= profits[i];
            weight -= weights[i];
            System.out.print(weights[i] + " ");
            i++;//V.V.IMP., but in case of 0/1 knapsack we dont do it
        }
      }
      if(totalProfit!=0){
        int countFirstItem =  totalProfit/profits[0];
        for(int i = 1 ; i<=countFirstItem;i++)
        System.out.print(weights[0]+" ");
    }
      System.out.println();
      return dp[profits.length-1][capacity];
    }
  
    public static void main(String[] args) {
      UnboundedKnapsackBottomUp ks = new UnboundedKnapsackBottomUp();
      int[] profits = { 15, 50, 60, 90 };
      int[] weights = { 1, 3, 4, 5 };    
      int maxProfit = ks.solveKnapsack(profits, weights, 10);//180
      System.out.println("Profit: "+maxProfit);
      maxProfit = ks.solveKnapsack(profits, weights, 12);//210
      System.out.println("Profit: "+maxProfit);
      profits = new int[] { 50, 60, 90, 15 };
      weights = new int[] { 3, 4, 5,1 };  
      maxProfit = ks.solveKnapsack(profits, weights, 12);//210
      System.out.println("Profit: "+maxProfit);
      
    }
  }
