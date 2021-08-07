class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList(); 
        backtrack(0,nums,result);
        return result;
    }
    void backtrack(int index, int[] nums, List<List<Integer>> result){
        if(index==nums.length-1){
            ArrayList<Integer> list = new ArrayList();
            for(int i: nums)
                list.add(i);
            result.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            backtrack(index+1,nums,result);
            swap(nums,index,i);
        }
    }
    void swap(int[] nums, int a , int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}