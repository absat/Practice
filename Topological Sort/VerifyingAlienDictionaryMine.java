class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> rank = new HashMap<>();
        int index=0;
        for(char c: order.toCharArray()){
            rank.put(c, ++index);
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i], word2 = words[i+1];

            if(word1.length()>word2.length() && word1.startsWith(word2))
                return false;
            
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                char c = word1.charAt(j), d = word2.charAt(j);
                System.out.println("c "+c+"d "+d);
                if(c!=d){
                    if(rank.get(c)>rank.get(d)){
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