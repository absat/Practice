class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        Arrays.sort(nums);
        int n= nums.length;
        Set<String> seen = new HashSet();
        for(int i = (int)Math.pow(2,n);i<(int)Math.pow(2,n+1);i++){
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> currentSubset = new ArrayList();
            StringBuilder hashcode = new StringBuilder();
            for(int j=0;j<n;j++){
                if(bitmask.charAt(j)=='1'){
                    currentSubset.add(nums[j]);
                    hashcode.append(nums[j]+",");
                }
            }
            if(!seen.contains(hashcode.toString())){
                subsets.add(currentSubset);
                seen.add(hashcode.toString());
            }
        }
        return subsets;
    }
}