import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    // Write your code here.
    if(array.length<1)
      return 0;
    if(array.length<2){
      return array[0];
    }

    int prevPrev = array[0], prev = Math.max(array[0],array[1]);
    for(int i=2;i<array.length;i++){
      int temp = prev;
      prev = Math.max(array[i]+prevPrev,prev);
      prevPrev = temp;
    }
    return prev;
  }
}
