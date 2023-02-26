class Solution {
    List<List<Integer>> sets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sets= new ArrayList<List<Integer>>();
        ArrayList<Integer> set = new ArrayList();
        Arrays.sort(nums);
        backtrack(0,nums,set);
        return sets;
    }
        void backtrack(int index, int[] nums, ArrayList<Integer> set){
            sets.add(new ArrayList<>(set));
            for(int i = index;i<nums.length;i++){
                if(i>index && nums[i]==nums[i-1])
                    continue;
                set.add(nums[i]);
                backtrack(i+1,nums,set);
                set.remove(set.size()-1);
            }
        }
}

//TC O(N*2^N),  
//SC O(N) For set, not counting sets
//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))


