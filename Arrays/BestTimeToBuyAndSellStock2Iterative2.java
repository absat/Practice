class Solution {
    public int maxProfit(int[] prices) {
        return calculatePrices(prices,0);
    }
    public int calculatePrices(int[] prices, int index){
        int profit=0,i=0;
      for(i=1;i<prices.length;i++)
      {
          if(prices[i]>=prices[i-1])
              profit+=prices[i]-prices[i-1];
      }
        return profit;
    }
}
//t o(n)
//s o(1)