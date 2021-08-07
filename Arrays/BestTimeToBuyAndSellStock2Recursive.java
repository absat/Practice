class Solution {
    public int maxProfit(int[] prices) {
        return calculatePrices(prices,0);
    }
    public int calculatePrices(int[] prices, int index){
        if(index>=prices.length)
            return 0;
        int max=0;
        for(int i=index;i<prices.length;i++){
            int max2=0;
            for(int j=i+1;j<prices.length;j++){
                int profit=prices[j]-prices[i]+calculatePrices(prices,j+1);
                 if (profit > max2)
                        max2 = profit;
            }
            if(max2>max)
                max=max2;
        }
        return max;
            
    }
}
//t o(n^n), Recursive function is called n^n times
//s o(n), depth of recursion is n