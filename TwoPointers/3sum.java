class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)//val must be less than= 0 as otherwise triplet sum cannot be 0
            if (i == 0 || nums[i - 1] != nums[i]) {//i==0, as we are doing compare with prev, so omit for i==0
                twoSumII(nums, i, res);
            }
        return res;

    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> res){
        int lo = i + 1, hi = nums.length - 1;
        while(lo<hi){
            int sum=nums[i]+nums[lo]+nums[hi];
            if(sum<0){
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));//incrment lo & hi for next iteration
                while(lo<hi && nums[lo]==nums[lo-1]){
                    ++lo;//idea is to make sure we get unique answers, as remember values can be repeated, here we increment lo, alternatively we can decrement hi as shown below
                }
                //while(lo<hi && nums[hi]==nums[hi+1]){
                   // --hi;
            }
        }
    }
}
//tc o (n2) as n times twonSumII which is o(n)
//sc o n or o logn depends on sorting algo