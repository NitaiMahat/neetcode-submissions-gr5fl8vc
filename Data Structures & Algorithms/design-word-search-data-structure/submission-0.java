class TrieNode{
    TrieNode[] children;
    boolean isValid;
    public TrieNode(){
        children = new TrieNode[26];
        isValid = false;
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isValid = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    private boolean dfs(String word,int index,TrieNode root){
        TrieNode curr = root;
        if(index==word.length()){
            return root.isValid;
        }
            if(word.charAt( index)=='.'){
                for(TrieNode node : curr.children){
                    if(node!=null){
                        if(dfs(word,index+1,node)){
                            return true;
                        }
                    }
                }
                return false;
            }
                if(curr.children[word.charAt( index)-'a'] == null){
                    return false;
                }else{
                    curr = curr.children[word.charAt( index)-'a'];
                }
            
        
        return dfs(word,index+1,curr);
    }
}
