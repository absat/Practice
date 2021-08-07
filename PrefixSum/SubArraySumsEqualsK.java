class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap();
        int cumulativeSum = 0;
        int count=0;
        for(int n: nums){
            cumulativeSum+=n;
            if(cumulativeSum==k)
                count++;
            
            count+=hm.getOrDefault(cumulativeSum-k,0);
            
            hm.put(cumulativeSum,hm.getOrDefault(cumulativeSum,0)+1);
                
        }
        return count;
    }
}