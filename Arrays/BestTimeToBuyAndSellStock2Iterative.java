class Solution {
    public int maxProfit(int[] prices) {
        return calculatePrices(prices,0);
    }
    public int calculatePrices(int[] prices, int index){
       int valley=prices[0],peak=prices[0];
        int i=0,max=0;
        while(i<prices.length-1){
            while(i<prices.length-1&&prices[i+1]<prices[i])
            {
                i++;
            }
            valley=prices[i];
             while(i<prices.length-1&&prices[i+1]>=prices[i])
            {
                i++;
            }
            peak=prices[i];
            max+=peak-valley;
        }
          return max;  
    }
}
//t o(n)
//s o(1)