class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] curr =  queue.poll();
            int row = curr[0];
            int col= curr[1];

            int[][] direction = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
            };
            for(int[] dir : direction){
                int newRow = row + dir[0];
                int newCol= col + dir[1];

                if(newRow < 0 || newCol <0 || newRow >= grid.length || newCol >= grid[0].length){
                    continue;
                }
                if(grid[newRow][newCol]!= Integer.MAX_VALUE){
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] +1;

                queue.add( new int[]{newRow,newCol});

            }

            
        }


    

    

    
    }
}           