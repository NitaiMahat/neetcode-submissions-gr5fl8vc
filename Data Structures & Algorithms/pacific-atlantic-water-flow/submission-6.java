class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null){
            return null;
        }
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            dfs(heights,pacific,i,0,heights[i][0]);
            dfs(heights,atlantic,i,heights[0].length-1,heights[i][heights[0].length-1]);
        }
        for(int i=0;i<heights[0].length;i++){
            dfs(heights,pacific,0,i,heights[0][i]);
            dfs(heights,atlantic,heights.length-1,i,heights[heights.length-1][i]);

        }
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    finalList.add(temp);
                }
            }
        }
        return finalList;


    }
    private void dfs(int[][] grid, boolean[][] oce , int row,int col,int prev ){
        if(row<0 || col <0 || row >= grid.length || col >= grid[0].length|| prev > grid[row][col]){
            return;
        }
        if(oce[row][col] ){
            return;
        }
        oce[row][col] = true;
        dfs(grid,oce,row+1,col,grid[row][col]);
        dfs(grid,oce,row-1,col,grid[row][col]);
        dfs(grid,oce,row,col+1,grid[row][col]);
        dfs(grid,oce,row,col-1,grid[row][col]);
    }
}
