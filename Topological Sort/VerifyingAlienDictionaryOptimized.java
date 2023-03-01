class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        int index=0;
        for(char c: order.toCharArray()){
            rank[c-'a']=++index;
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i], word2 = words[i+1];

            if(word1.length()>word2.length() && word1.startsWith(word2))
                return false;
            
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                char c = word1.charAt(j), d = word2.charAt(j);
                if(c!=d){
                    if(rank[c-'a']>rank[d-'a']){
                        return false;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return true;
    }
}