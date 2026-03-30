class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int count =0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    markVisited(grid,i,j);//mark visited as 0
                }
            }
        }
        return count;


    }
    private void markVisited(char[][] grid,int rows, int cols){
        if(rows <0 || cols < 0 || rows > grid.length-1 || cols  > grid[0].length-1 || grid[rows][cols]=='0'){
            return;
        }
        grid[rows][cols] = '0';

        markVisited(grid, rows-1,cols);
        markVisited(grid, rows+1,cols);
        markVisited(grid, rows,cols-1);
        markVisited(grid, rows,cols+1);
    }
}
