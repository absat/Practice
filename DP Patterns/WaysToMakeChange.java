public class WaysToMakeChange {
    /*
     * target denomination say 6
     * coins say 1,2,5,10
     * ways
     * all 1s
     * 1,1,2,2
     * 1,1,1,2,1
     * all 2s
     * 1,5
     */
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int denom: denoms){
          for(int i=0;i<=n;i++){
            if(denom<=i){
              ways[i] += ways[i-denom];
            }
          }
        }
        return ways[n];
      }

    /*
     * time o(nd), where d is denoms arr
     * space o(n)
     */
      
}
