public class UnboundedKnapsackBruteForce {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      return solve(profits,weights,capacity,0);
    }
  
    public int solve(int[] profits, int[] weights, int capacity,int index)
    {
      if(profits.length==0||index==profits.length||capacity==0)
        return 0;
      int set1 = 0;
      if(capacity-weights[index]>=0)
        set1 = profits[index]+solve(profits,weights,capacity-weights[index],index);
      int set2 = solve(profits,weights,capacity, index+1);
      return Math.max(set1,set2);
    }
  
    public static void main(String[] args) {
      UnboundedKnapsackBruteForce ks = new UnboundedKnapsackBruteForce();
      int[] profits = { 15, 50, 60, 90 };
      int[] weights = { 1, 3, 4, 5 };
      int maxProfit = ks.solveKnapsack(profits, weights, 10);
      System.out.println(maxProfit);
    }
  }
  