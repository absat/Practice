class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList();
        Map<String,List> ans = new HashMap();
        int[] count = new int[26];
        for(String s: strs){
            Arrays.fill(count,0);
            for(char c: s.toCharArray())
                count[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int freq: count){
                sb.append(freq);
                sb.append("#");
            }
            String key = sb.toString();
            if(!ans.containsKey(key))
                ans.put(key,new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
//TC: O(NK), N total strings, K length of longest word
//SC: O(NK), hashmap, N strings of size K at most