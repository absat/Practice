class Solution {
    public String addBinary(String a, String b) {
        int l1=a.length()-1,l2=b.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(l1>=0||l2>=0){
            int n1 = l1>=0?a.charAt(l1)-'0':0;
            int n2 = l2>=0?b.charAt(l2)-'0':0;
            int sum=n1+n2+carry;
            sb.append(sum%2);
            carry=sum/2;
            l1--;
            l2--;
        }
        if(carry!=0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}