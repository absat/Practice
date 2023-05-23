class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl=s.length(),tl=t.length(),sp=0,tp=0;
        while(tp<tl&&sp<sl){
            if(s.charAt(sp)==t.charAt(tp)){
                sp++;
            }
            tp++;
        }
        return sp==sl;
    }
}
//tc o(length(target)), sc o(1)