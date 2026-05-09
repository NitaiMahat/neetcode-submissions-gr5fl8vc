class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length == 0){
            return -1;
        }
         int minute = 0;
         int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        while(!queue.isEmpty() &&  freshCount >0){
            int size = queue.size();
            for(int i= 0;i<size;i++){
                int[] currArr = queue.poll();
            int row = currArr[0];
            int col = currArr[1];
            int[][] direction = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
            };
            for(int[] dir : direction){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow <0 || newCol <0 || newRow >= grid.length || newCol >= grid[0].length){
                    continue;
                }
                if(grid[newRow][newCol]== 0){
                    continue;
                }

                if(grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    freshCount--;
                    queue.add(new int[]{newRow,newCol});
                }
            }
            }
            minute++;
            
        }
        if(freshCount >0){
            return -1;
        }
        return minute;
    }
    
}
