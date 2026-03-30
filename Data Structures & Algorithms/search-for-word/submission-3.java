class Solution {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for(int i=0;i<ROWS;i++){
            for(int j=0; j < COLS;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean result = backTrack(board,i,j,word,0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean backTrack(char[][] board, int row,int col,String word,int index){
        if(index==word.length()){
            return true;
        }
        if(row <0 || col <0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)|| visited[row][col]){
            return false;
        }
        visited[row][col] = true;
        if(backTrack(board,row+1,col,word,index+1)||
        backTrack(board,row,col+1,word,index+1)||
        backTrack(board,row-1,col,word,index+1)||
        backTrack(board,row,col-1,word,index+1)){
            return true;
        }
        visited[row][col] = false;
        return false;
     

    }
}
