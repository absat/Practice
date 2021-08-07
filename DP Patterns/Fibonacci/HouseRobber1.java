class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return solve(nums,0,dp);
    }
    int solve(int[] nums, int index,Integer[] dp){
        if(index>=nums.length)
            return 0;
        if(dp[index]==null){
             int path1 = nums[index] + solve(nums,index+2,dp);
             int path2 = solve(nums,index+1,dp);
             dp[index]= Math.max(path1,path2);
        }
        return dp[index];
    }
}

class Solution1 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
        }
        
        return dp[nums.length];
    }
}

class Solution2 {
    public int rob(int[] nums) {
        int n1=0;
        int n2=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=Math.max(n2,n1+nums[i]);
            n1=n2;
            n2=temp;
        }
        
        return n2;
    }
}