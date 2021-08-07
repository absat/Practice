class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            backtrack(ans, sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backtrack(ans, sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//TC & S:  O( (4^N) / (SQRT(N)) )