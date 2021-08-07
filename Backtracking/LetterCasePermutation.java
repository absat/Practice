class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList();
        backtrack(ans,0,new StringBuilder(),s);
        return ans;
    }
    void backtrack(List<String> ans, int index ,StringBuilder sb, String s){
        if(index>=s.length()){
            ans.add(sb.toString());
            return;
        }
        if(Character.isLetter(s.charAt(index))){
            sb.append(s.charAt(index));
            backtrack(ans,index+1,sb,s);
            sb.deleteCharAt(sb.length()-1);
            if(Character.isLowerCase(s.charAt(index))){
                sb.append(Character.toUpperCase(s.charAt(index)));    
            }
            else{
                sb.append(Character.toLowerCase(s.charAt(index)));    
            }  
            backtrack(ans,index+1,sb,s);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(s.charAt(index));
            backtrack(ans,index+1,sb,s);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
// TC O( (2^N) * N)
// SC O( (2^N) * N)