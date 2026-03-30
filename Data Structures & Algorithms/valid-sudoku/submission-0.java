class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char currentVal = board[i][j];
                if(currentVal != '.'){
                    if((!set.add(currentVal + " found in row " + i))||
                    (!set.add(currentVal + " found in column " + j))||
                    (!set.add(currentVal + " found in subBox " + i/3 + "-" + j/3))){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
