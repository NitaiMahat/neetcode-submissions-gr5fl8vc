class Solution {
    int ROWS;
    int COLS;
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        ROWS = grid.length;
        COLS = grid[0].length;
        int[][] time = new int[ROWS][COLS];
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]!=2){
                    time[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]==2){
                    dfs(grid,time,i,j,0);
                }
            }
        }

        int result = 0;
        for(int n=0;n<ROWS;n++){
            for(int m=0;m<COLS;m++){
                if(grid[n][m]==1){

                
                if(time[n][m]==Integer.MAX_VALUE){
                    return -1;
                }
                result = Math.max(result,time[n][m]);
            }
            }
        }
        return result;
    }

    private void dfs(int[][] grid,int[][] time,int i , int j,int currentTime){
        if(i<0 || i >= ROWS || j<0 || j >= COLS || time[i][j]< currentTime || grid[i][j]==0){
            return;
        }
        time[i][j] = currentTime;
        dfs(grid,time,i+1,j,currentTime+1);
        dfs(grid,time,i-1,j,currentTime+1);
        dfs(grid,time,i,j+1,currentTime+1);
        dfs(grid,time,i,j-1,currentTime+1);
    }
}
