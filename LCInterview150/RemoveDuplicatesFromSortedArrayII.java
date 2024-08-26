public class RemoveDuplicatesFromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left=1,right=0,count=1;
            for(right=1;right<nums.length;right++){
                if(nums[right]==nums[right-1]){
                    count++;
                }
                else {
                    count=1;
                }
                if(count<=2){
                    nums[left++] = nums[right];
                }
            }
            return left;
        }
    }
    //tc o n sc o 1
}
