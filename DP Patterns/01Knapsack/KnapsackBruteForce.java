
class KnapsackBruteForce {

    public static int knapsackRecursive(int[] profits, int[] weights, int maxWeight, int index){
        if(maxWeight<=0||index>=profits.length)
            return 0;
        int profit1=0;
        if(weights[index]<=maxWeight)
            profit1 = profits[index]+knapsackRecursive(profits, weights, maxWeight-weights[index], index+1);
        int profit2 = knapsackRecursive(profits, weights, maxWeight, index+1);
        return Math.max(profit1,profit2);
    }
    public static void main(String[] args) {
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = knapsackRecursive(profits, weights, 7, 0);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = knapsackRecursive(profits, weights, 6, 0);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    }
  }
  