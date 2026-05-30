class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        }
        int numOfBananas = 0;
      
        int minute = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    numOfBananas++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty() && numOfBananas>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                 int[] cord = queue.poll();
            numOfBananas-=dfs(grid,cord[0]-1,cord[1],queue);
            numOfBananas-=dfs(grid,cord[0]+1,cord[1],queue);
            numOfBananas-=dfs(grid,cord[0],cord[1]-1,queue);
            numOfBananas-=dfs(grid,cord[0],cord[1]+1,queue);
            }
            minute++;
           
            
        }
    



        if(numOfBananas==0){
            return minute;
        }else{
            return -1;
        }
    }
    private int dfs(int[][] grid,int row,int col , Queue<int[]> queue){
        if(row<0 || col <0 || row>=grid.length || col >= grid[0].length|| grid[row][col]!=1){
            return 0;
        }
        grid[row][col] = 2;
       
        queue.add(new int[]{row,col});
        return 1;
    }
}
