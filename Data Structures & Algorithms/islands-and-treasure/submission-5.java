class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0){
            return;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }
    private void dfs(int[][] grid,int row,int col,int level){
        if(row<0 || col <0 || row> grid.length-1 || col > grid[0].length-1 || grid[row][col] == -1 || grid[row][col] < level){
            return;
        }
        grid[row][col] =level;
        dfs(grid,row-1,col,level+1);
        dfs(grid,row+1,col,level+1);
        dfs(grid,row,col+1,level+1);
        dfs(grid,row,col-1,level+1);
    }
}
