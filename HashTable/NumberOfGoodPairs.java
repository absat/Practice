class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        for(int num: nums){
            sum += hm.getOrDefault(num,0);//only get can give nulls for new elem, use getof=rdeafult!
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        return sum;
    }
}