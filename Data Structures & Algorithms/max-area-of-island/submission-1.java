class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
       int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j]==1){

                    int count = countNodes(grid,i,j,1);
                    maxArea = Math.max(count,maxArea);
                }
            }
        }
        return maxArea;
    }
    private int countNodes(int[][] grid, int i,int j,int count){
        if(i<0 || j<0 || i >grid.length-1 || j > grid[0].length-1 || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
       return 1 + countNodes(grid,i-1,j,count)+
       countNodes(grid,i+1,j,count)+
        countNodes(grid,i,j-1,count)+
        countNodes(grid,i,j+1,count);
        
        
    }
}
