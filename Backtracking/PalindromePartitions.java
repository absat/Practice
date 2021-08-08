class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        boolean[][] dp = new boolean[s.length()][s.length()];
        backtrack(result,new ArrayList<String>(),0,s,dp);
        return result;
    }
    void backtrack(List<List<String>> result, List<String> currentList,int start,String s, boolean[][] dp){
        if(start==s.length())
            result.add(new ArrayList(currentList));
        for(int end=start;end<s.length();end++){
            if(s.charAt(end)==s.charAt(start)&&(end-start<=2 || dp[start+1][end-1])){
                dp[start][end]=true;
                currentList.add(s.substring(start,end+1));
                backtrack(result,currentList,end+1,s,dp);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
//TC O(N * 2^N)
//S O(N^2)