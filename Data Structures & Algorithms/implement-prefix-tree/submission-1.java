class TrieNode{
    TrieNode[] children;
    boolean isValid;
    public TrieNode(){
        children = new  TrieNode[26];
        isValid = false;
    }
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isValid = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }else{
                curr = curr.children[c-'a'];
            }
        }
        return curr.isValid;
    }

    public boolean startsWith(String prefix) {
         TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }else{
                curr = curr.children[c-'a'];
            }
        }
        return true;
    }
}
