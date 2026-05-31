class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                board[i][0] = 'T';
                dfs(board,i,0);
            }
             if(board[i][board[0].length-1]=='O'){
                board[i][board[0].length-1] = 'T';
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                board[0][i]='T';
            }
            if(board[board.length-1][i]=='O'){
                board[board.length-1][i] = 'T';
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'T'){
                    dfs(board,i-1,j);
                    dfs(board,i+1,j);
                    dfs(board,i,j-1);
                    dfs(board,i,j+1);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='T'){
                    board[i][j] = 'O';
                }
            }
        }

        
    }
    private void dfs(char[][] board , int row, int col){
        if(row<0 || col <0 || row >= board.length || col >= board[0].length || board[row][col]=='X' || board[row][col]=='T'){
            return;
        }
        board[row][col] = 'T';
        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);


    }
}
