class Solution {
    public void solve(char[][] board) {
        boolean[][] safe = new boolean[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i,safe);
            }
            if(board[board.length-1][i]=='O'){
                
                 dfs(board,board.length-1,i,safe);
            }
           
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                 dfs(board,i,0,safe);
            }
           if(board[i][board[0].length-1]=='O'){
                  dfs(board,i,board[0].length-1,safe);
           }
          
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(safe[i][j]!=true){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int row,int col, boolean[][] safe){
        if(row<0 || col < 0 || row> board.length-1 || col > board[0].length-1){
            return;
        }
        if(board[row][col]=='X'){
            return;
        }
        if (safe[row][col]) {
    return;
}
        safe[row][col] = true;
        dfs(board,row-1,col,safe);
        dfs(board,row+1,col,safe);
        dfs(board,row,col-1,safe);
        dfs(board,row,col+1,safe);
    }
}
