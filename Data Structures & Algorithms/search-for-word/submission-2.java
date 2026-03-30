class Solution {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(word.charAt(0)==board[i][j] && dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i,int j, int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 ||j<0|| i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(dfs(board,word,i+1,j,index+1)||
        dfs(board,word,i-1,j,index+1)||
        dfs(board,word,i,j-1,index+1)||
        dfs(board,word,i,j+1,index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
