class TrieNode{
    TrieNode[] children;
    boolean isValid;
    public TrieNode(){
        children = new TrieNode[26];
        isValid = false;
    }
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        if(word.isEmpty()){
            return;
        }
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a']==null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isValid = true;
    }

    public boolean search(String word) {

        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(current.children[c-'a']==null){
                return false;
            }
            current = current.children[c-'a'];
        }
        return current.isValid;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()){
            if(current.children[c-'a']==null){
                return false;
            }
            current = current.children[c-'a'];
        }
        return true;
    }
}
