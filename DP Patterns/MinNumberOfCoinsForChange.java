import java.util.Arrays;

/*
 * 
 */

public class MinNumberOfCoinsForChange {
      public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] dp = new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0]=0;
    for(int coin: denoms){
      for(int i=1;i<n+1;i++){
        if(i-coin>=0){
          if(dp[i-coin]!=Integer.MAX_VALUE){
            dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
          }
        }
      }
    }
   
    return dp[n] == Integer.MAX_VALUE ? -1: dp[n]; 
  }

  /*
   * o(nd) time, where d is denoms arr
   * o(s) space
   */

}
