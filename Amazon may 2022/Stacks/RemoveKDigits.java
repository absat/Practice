class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(char digit: num.toCharArray()){
            if(stack.size()>0 && k >0 && stack.peekLast()>digit){
                k-=1;
                stack.removeLast();
            }
            stack.addLast(digit);
        }

        for(int i=0;i<k;i++){
            stack.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero=true;
        for(char digit:stack){
            if(leadingZero && digit=='0')
                continue;
            leadingZero=false;
            sb.append(digit);
        }

        return sb.length() > 0 ? sb.toString():"0";
    }
}
//TC O(N)
//SC O(N), stackS