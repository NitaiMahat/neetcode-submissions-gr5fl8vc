class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }      
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int minute = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count++;
                }
               if(grid[i][j]==2){
                queue.add(new int[]{i,j});
               }
            }
        }
        while(!queue.isEmpty() && count >0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.poll();
              
                   
                    count -= dfs(grid,temp[0]-1,temp[1],queue);
                    count -= dfs(grid,temp[0],temp[1]-1,queue);
                    count -= dfs(grid,temp[0]+1,temp[1],queue);
                    count -= dfs(grid,temp[0],temp[1]+1,queue);
                
            }
             minute++;
        }
        if(count==0){
            return minute;
        }
        return -1;

    }
    private int dfs(int[][] grid,int row,int col,Queue<int[]> queue){
        if(row<0 || col <0 || row >= grid.length || col >= grid[0].length || grid[row][col]!=1){
            return 0 ;
        }
        grid[row][col] = 2;
        queue.add(new int[]{row,col});
        return 1;
    }
}
