class NumArray {
    private int[] cumSum;
    public NumArray(int[] nums) {
        cumSum = new int[nums.length];
        int index=0, prev=0;
        for(int n: nums){
            cumSum[index]=prev + nums[index];
            prev=cumSum[index];
            index++;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left>0)
            return cumSum[right]-cumSum[left-1];
        return cumSum[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */