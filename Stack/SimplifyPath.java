class Solution {
    public String simplifyPath(String path) {
        String[] textArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String text: textArr){
            if(text.equals("") || text.equals(".")){
                continue;
            } else if(text.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            } else {
                stack.push(text);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String text: stack){
            sb.append("/");
            sb.append(text);
        }
        return sb.length()>0 ? sb.toString():"/";
    }
}
//tc and sc 
//tc o(n), for split function only order of n
//sc we use string array and also stack so on +on = o of 2n = o of n