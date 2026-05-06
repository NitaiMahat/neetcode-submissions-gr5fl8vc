class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int maxArea = 0;
  
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]==1){
                    int count = dfs(grid,i,j,1);
                    maxArea = Math.max(maxArea,count);
                }

            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int row, int col,int count){
        if(row<0 || col <0 || row>= grid.length || col>= grid[0].length || grid[row][col]==0){
            return 0;
        }
        grid[row][col] = 0;
        return 1 +
        + dfs(grid,row,col+1,count)+
        dfs(grid,row,col-1,count)+
        dfs(grid,row+1,col,count)+
        dfs(grid,row-1,col,count);
       
    }
    
}
