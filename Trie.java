class Trie {
    
    /** Initialize your data structure here. */
    private TrieNode root;

    public Trie() {
         root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c))
                node.put(c,new TrieNode());//imp
            node = node.get(c);
        }
        node.setEnd();//imp
    }
    
    private TrieNode baseSearch(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c))
                return null;
            node = node.get(c);

        }
        return node;
    }
    
      /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = baseSearch(word);
        return node!=null&&node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = baseSearch(prefix);
        return node!=null;
    }
}
class TrieNode{
    private TrieNode[] links;
    private boolean isEnd;
    private final int R=26;
    public TrieNode(){
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    public TrieNode get(char ch)
    {
        return links[ch-'a'];
    }
    
    public void put(char ch,TrieNode node){//imp node arg
        links[ch-'a'] = node;
    }
    
    public void setEnd(){
        isEnd=true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */



