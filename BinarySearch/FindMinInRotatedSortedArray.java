class Solution {
    public int findMin(int[] nums) {
        int left=0, n=nums.length;
        int right = n-1;
        if(n==1)
            return nums[0];
        if(nums[left]<nums[right])
            return nums[left];

        while(left<=right){
            int mid= left +(right-left)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            else if(nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[mid]>nums[0])
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
    }
}
//TC O OF LOG N
//SC O OF 1