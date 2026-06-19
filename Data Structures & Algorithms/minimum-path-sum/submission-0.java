class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        return dfs(grid,0,0,dp);
    }
    private int dfs(int[][] grid , int row, int col , int[][] dp){
        if(row<0 || col <0 || row>= grid.length || col >=grid[0].length){
            return 999;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int right = dfs(grid,row,col+1,dp);
        int left = dfs(grid,row+1,col,dp);
        dp[row][col] = grid[row][col] + Math.min(right,left);
        return dp[row][col];

    }
}