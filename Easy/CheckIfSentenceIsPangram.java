class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for(char c:sentence.toCharArray()){
            count[c-'a']+=1;
        }
        for(int c:count){
            if(c==0)
                return false;
        }
        return true;
    }
    //sc array of size 26 so o of 1
}