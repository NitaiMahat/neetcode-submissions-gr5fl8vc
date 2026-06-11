class TrieNode{
     TrieNode[] children;
     boolean isValid;
    public  TrieNode(){
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
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isValid = true;

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c-'a';
            if(curr.children[index]== null ){
                return false;
            }else{
                curr= curr.children[index];
            }
        }
        return curr.isValid;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int count = 0;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] ==null){
                return false;
            }else{
                curr = curr.children[idx];
            }
        }
        return true;
    }
}
