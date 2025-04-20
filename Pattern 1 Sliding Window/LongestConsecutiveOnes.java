public class LongestConsecutiveOnes {
    public static void main(String[] args){
        //int[] arr = {1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1};//last set 12+1
        int[] arr = {1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1};
        solve(arr);
    }

    private static void solve(int[] arr){
        int left = 0,  right = 0, zeros = 0;
        int currentCount = 0;
        for(right=0;right<arr.length;right++){
            if(arr[right]==0){
                zeros+=1;
            }
            while(zeros>1){
                if(arr[left]==0)
                    zeros-=1;
                left++;
            }
            currentCount = Math.max(currentCount, right-left+1);
        }
        System.out.println(currentCount);
    }
    
}
