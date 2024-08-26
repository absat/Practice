class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(stack.empty() || c!=stack.peek()){
                stack.push(c);
            } else {
                while(!stack.empty() && c==stack.peek()){
                    c = stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            char top = stack.pop();
            sb.append(top);
        }
        return sb.reverse().toString();
    }
}
//TC O(N)
//SC O(N-D), D is length of all duplicates