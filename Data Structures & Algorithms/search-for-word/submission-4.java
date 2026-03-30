class Solution {
    private int ROWS;
    private int COLS;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]== word.charAt(0)){
                    if(helper(i,j,word,board,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(int row,int col,String word, char[][] board,int index){
        if(index == word.length()){
            return true;
        }
        if(row <0 || col <0 || row >=ROWS || col >=COLS ||board[row][col]!=word.charAt(index) || visited[row][col]){
            return false;
        }
        visited[row][col] = true;
        if(helper(row+1,col,word,board,index+1)||
        helper(row-1,col,word,board,index+1)||
        helper(row,col+1,word,board,index+1)||
        helper(row,col-1,word,board,index+1)){
            return true;
        }
        visited[row][col] = false;

        return false;


    }
}
