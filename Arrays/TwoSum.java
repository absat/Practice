/*class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}*/
//tc and sc o of n

 import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Set<Integer> set = new HashSet<>();
    for(int num:array){
      if(set.contains(targetSum-num))
        return new int[]{num,targetSum-num};
      else
        set.add(num);
    }
    return new int[0];
  }
}

 