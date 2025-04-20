class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cloneArray = nums.clone();
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.putIfAbsent(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            cloneArray[i] = map.get(cloneArray[i]);
        }
        return cloneArray;
    }
}