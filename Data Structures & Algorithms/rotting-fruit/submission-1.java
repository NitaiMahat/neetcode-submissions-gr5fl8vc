class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount =0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j]==2){
                    queue.add(new int[] {i,j});
                }
            }
        }
        int min = 0;
        while(!queue.isEmpty() && freshCount>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                if(r-1 >=0 && grid[r-1][c]==1){
                    freshCount--;
                    grid[r-1][c]=2;
                    queue.add(new int[] {r-1,c});
                }if(r+1 < grid.length && grid[r+1][c]==1){
                     freshCount--;
                    grid[r+1][c]=2;
                    queue.add(new int[] {r+1,c});
                } if(c-1 >=0 && grid[r][c-1]==1){
                     freshCount--;
                    grid[r][c-1]=2;
                    queue.add(new int[] {r,c-1});
                } if(c+1 < grid[0].length && grid[r][c+1]==1){
                     freshCount--;
                    grid[r][c+1]=2;
                    queue.add(new int[] {r,c+1});
                }
                   

            }
            min++;
        }
        if(freshCount>0){
            return -1;
        }
        return min;
    }
   
}
