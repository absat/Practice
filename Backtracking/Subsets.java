public class Subsets {
    List<List<Integer>> sets;
    public List<List<Integer>> subsets(int[] nums) {
        sets = new ArrayList<List<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        backtrack(nums,0,set);
        return sets;
    }
    private void backtrack(int[] nums, int index, ArrayList<Integer> set){
        sets.add(new ArrayList<>(set));
        for(int i=index;i<nums.length;i++){
            set.add(nums[i]);
            backtrack(nums,i+1,set);
            set.remove(set.size()-1);
        }
    }
}
//TC O(N*2^N),  
//SC O(N) For set, not counting sets
//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))
