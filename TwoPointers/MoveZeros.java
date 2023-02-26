class Solution {
    public void moveZeroes(int[] nums) {
        int zeros=0,start=0,end=0;
        for( end=0;end<nums.length;end++){
            if(nums[end]!=0){
                nums[start]=nums[end];
                start+=1;
            }
        }
        for(int i=start;i<nums.length;i++)
            nums[i]=0;
    }
}