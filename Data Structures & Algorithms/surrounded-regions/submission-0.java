class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        if(board==null || board.length==0){
            return;
        }
        ROWS = board.length;
         COLS = board[0].length;

        for(int i=0;i<ROWS;i++){
            replace(board,i,0);
            replace(board,i,COLS-1);
        }
        for(int j=0;j<COLS;j++){
            replace(board,0,j);
            replace(board,ROWS-1,j);
        }

        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='O'){
                    board[i][j]= 'X';
                }
            }
        }
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='S'){
                    board[i][j]= 'O';
                }
            }
        }
    }
    private void replace(char[][] board,int i,int j){
        if(i<0 || i>=ROWS || j<0 || j >=COLS){
            return;
        }
        if(board[i][j]!='O'){
            return;
        }
        board[i][j] = 'S';
        replace(board,i+1,j);
        replace(board,i-1,j);
        replace(board,i,j-1);
        replace(board,i,j+1);
    }
}
