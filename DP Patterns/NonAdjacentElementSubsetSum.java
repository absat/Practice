/*
 * compute max sum of non adjacent elements
 * [13,5,8,15,21,20]
 * 13+8+21 vs 5+15+20, so 42
 */
import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if(array.length==0)
      return 0;
    if(array.length==1)
      return array[0];

    int prevPrev=array[0], prev = Math.max(array[0],array[1]);

    for(int i=2;i<array.length;i++){
      int current = Math.max(prev, prevPrev+array[i]);
      prevPrev = prev;
      prev = current;
    }
    return prev;
  }
}

/*
 * max[i] = Math.max(max[i-1], max[i-2] + arr[i])
 * o(n) time, o(1) space
 */