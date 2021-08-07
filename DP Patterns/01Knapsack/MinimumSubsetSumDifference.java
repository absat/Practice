public class MinimumSubsetSumDifference  {

    public int canPartition(int[] num) {
      int sum1= 0, sum2 =0;
      return solve(num,0,sum1,sum2);
    }

    public int solve(int[] num, int index, int sum1, int sum2){
        if(index==num.length)
            return Math.abs(sum1-sum2);
        int diff1 = solve(num,index+1,sum1+num[index],sum2);
        int diff2  = solve(num,index+1,sum1,sum2+num[index]);
        return Math.min(diff1,diff2);
    } 
    public static void main(String[] args) {
      MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
      int[] num = {1, 2, 3, 9};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ps.canPartition(num));
      num = new int[]{1, 3, 100, 4};
      System.out.println(ps.canPartition(num));
    }
  }
 