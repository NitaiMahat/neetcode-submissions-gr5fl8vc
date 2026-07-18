class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
}
class Solution {
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            insert(word);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root);
            }
        }
        return result;

    }
    private void dfs(char[][] board, int i,int j,TrieNode root){
        if(i<0|| j<0 || i>=board.length || j>=board[0].length || board[i][j] == '#'){
            return;
        }
        TrieNode curr = root;
        curr = curr.children[board[i][j]-'a'];
        if(curr==null){
            return;
        }
        if(curr.word!=null){
            result.add(curr.word);
            curr.word = null;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        dfs(board,i-1,j,curr);
         dfs(board,i,j+1,curr);
          dfs(board,i,j-1,curr);
           dfs(board,i+1,j,curr);

        board[i][j] = temp;
    }
    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
}
