class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> finalList = new ArrayList<>();
        for(String word:words){
            if(exist(board,word)){
                finalList.add(word);
            }
        }
        return finalList;
    }
    private boolean exist(char[][] board, String word) {
       boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,word,0,i,j,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int index,int row,int col,boolean[][] visited){

        if(row<0 || col<0 || row>= board.length || col>=board[0].length|| visited[row][col]){
            return false;
        }
         if(board[row][col]!=word.charAt(index)){
            return false;
        }
       if(index == word.length()-1){
        return true;
       }
       
        visited[row][col] = true;
       boolean found =  dfs(board,word,index+1,row+1,col,visited) ||
        dfs(board,word,index+1,row,col-1,visited) ||
        dfs(board,word,index+1,row-1,col,visited)||
        dfs(board,word,index+1,row,col+1,visited);
        visited[row][col] = false;
        return found;
    }
}
