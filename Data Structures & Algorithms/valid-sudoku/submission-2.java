class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seenSet = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char currentChar = board[i][j];
                if(currentChar!='.'){
                    if(!seenSet.add( currentChar + " found in row " + i) || !seenSet.add(currentChar + " found in col " + j) || !seenSet.add(currentChar + " found in subBox " + i/3 + " - " + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
