class Solution {
    int[][] DIRS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> indexQueue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }
                if(grid[i][j]==2){
                    indexQueue.add(new int[]{i,j});
                }
            }
        }
        if (freshCount == 0){
              return 0;
        }
       
        int minute = 0;
        while(!indexQueue.isEmpty()){
             boolean rotton = false;
            int size = indexQueue.size();
            for(int i=0;i<size;i++){
            int[] currIndex = indexQueue.poll();
            int row = currIndex[0];
            int col = currIndex[1];

            for(int[] dir: DIRS){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length){
                    continue;
                }
                if(grid[newRow][newCol]!=1){
                    continue;
                }
                rotton = true;
                grid[newRow][newCol] = 2;
                freshCount--;
                indexQueue.add(new int[]{newRow,newCol});
            }
            }
            if(rotton){
                minute++;
            }
            

            
        }
        if(freshCount!=0){
            return -1;
        }
        return minute;
    }
}
