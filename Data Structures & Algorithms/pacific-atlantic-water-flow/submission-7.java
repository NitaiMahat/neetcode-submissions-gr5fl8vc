class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
         boolean[][] atlantic = new boolean[heights.length][heights[0].length];
         for(int i=0;i<heights.length;i++){
            fillOcean(heights,i,0,pacific,heights[i][0]);
            fillOcean(heights,i,heights[0].length-1,atlantic, heights[i][heights[0].length-1]);
         }
         for(int i=0;i<heights[0].length;i++){
            fillOcean(heights,0,i,pacific,heights[0][i]);
            fillOcean(heights,heights.length-1,i,atlantic,heights[heights.length-1][i]);
         }

         List<List<Integer>> finalList = new ArrayList<>();
         for(int i=0;i<pacific.length;i++){
            for(int j=0;j<pacific[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    finalList.add(Arrays.asList(i,j));
                }
            }
         }
         return finalList;
    }
    private void fillOcean(int[][] heights, int row,int col,boolean[][] ocean,int prev){
        if(row<0 || col<0 || row>= heights.length || col>=heights[0].length ||ocean[row][col]){
            return;
        }
        if(prev > heights[row][col]){
            return;
        }
        ocean[row][col] = true;
        fillOcean(heights,row-1,col,ocean,heights[row][col]);
         fillOcean(heights,row+1,col,ocean,heights[row][col]);
          fillOcean(heights,row,col-1,ocean,heights[row][col]);
           fillOcean(heights,row,col+1,ocean,heights[row][col]);
    }
}
