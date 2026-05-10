class Solution {
    public void solve(char[][] board) {
       
        for(int i=0;i<board.length;i++){
            safe(board,i,0);
            safe(board,i,board[0].length-1);
        }
        for(int i=0;i<board[0].length;i++){
            safe(board,0,i);
            safe(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void safe(char[][] board, int row, int col){
        if(row<0 || col <0 || row>= board.length || col >= board[0].length || board[row][col] == 'X'||  board[row][col] == 'T'){
            return;
        }
        if(board[row][col]=='O'){
            board[row][col] = 'T';
        }
        safe(board,row-1,col);
        safe(board,row+1,col);
        safe(board,row,col-1);
        safe(board,row,col+1);
    }
}
