class Solution {
    public boolean backspaceCompare(String s, String t) {
        return solve(s).equals(solve(t));
    }

    private String solve(String s){
        StringBuilder stack = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='#'){
                if(stack.length()>0){
                    stack.deleteCharAt(stack.length()-1);
                }
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
//TC & SC O(M+N)