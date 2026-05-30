class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid.length==0){
            return;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }
    private void dfs(int[][] grid,int row,int col,int dist){
        if(row<0 || col <0 || row>= grid.length || col >= grid[0].length || grid[row][col]==-1 || grid[row][col] <dist){
            return;
        }
        grid[row][col] = dist;
        dfs(grid,row+1,col,dist+1);
        dfs(grid,row-1,col,dist+1);
        dfs(grid,row,col+1,dist+1);
        dfs(grid,row,col-1,dist+1);
    }
}
