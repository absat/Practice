class Solution {
    public int expressiveWords(String s, String[] words) {
        int count=0;
        for(String w: words){
            if(stretchy(s,w))
                count++;
        }
        return count;
    }
    boolean stretchy(String s, String w){
        int l1=s.length(),l2=w.length(), i=0,j=0;
        while(i<l1 && j<l2){
            int c1=1,c2=1;
            // Here increment is crucial, so as to be able to compare with previous char below
            if(s.charAt(i++) != w.charAt(j++))
                return false;
            while(i<l1 && s.charAt(i)==s.charAt(i-1)){
                c1++;
                i++;
            }
            while(j<l2 && w.charAt(j)==w.charAt(j-1)){
                c2++;
                j++;
            }
            if(c1==c2 || c1>c2 && c1>=3)
                continue;
            return false;
        }
        return i==l1 && j==l2;
    }
}