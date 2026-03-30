class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i+1,j,1);
                    dfs(grid,i-1,j,1);
                    dfs(grid,i,j+1,1);
                    dfs(grid,i,j-1,1);
                    
                }
            }
        }


    }
    private void dfs(int[][] grid,int i,int j,int distance){
        if(i<0 || j <0 || i > grid.length-1 || j > grid[0].length-1){
            return;
        }
        if(grid[i][j] > distance){
            grid[i][j] = distance;
            dfs(grid,i-1,j,distance+1);
            dfs(grid,i+1,j,distance+1);
            dfs(grid,i,j-1,distance+1);
            dfs(grid,i,j+1,distance+1);
        }
    }
}
