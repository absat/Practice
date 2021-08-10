class Solution {
    public String addStrings(String num1, String num2) {
     StringBuilder res = new StringBuilder();
        int l1=num1.length()-1,l2=num2.length()-1;
        int carry=0;
        while(l1>=0||l2>=0){
            int n1=l1>=0?num1.charAt(l1)-'0':0;
            int n2=l2>=0?num2.charAt(l2)-'0':0;
            int result=(n1+n2+carry)%10;
            carry=(n1+n2+carry)/10;
            res.append(result);
            l1--;
            l2--;
        }
        if(carry!=0)
            res.append(carry);
        return res.reverse().toString();
    }
}