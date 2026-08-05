class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*

        */
        List<List<Integer>> finalList = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for(int i=0;i<heights.length;i++){
            fillOcean(heights,pacific,i,0,heights[i][0]);
            fillOcean(heights,atlantic,i,heights[0].length-1,heights[i][heights[0].length-1]);
        }
        for(int i=0;i<heights[0].length;i++){
            fillOcean(heights,pacific,0,i,heights[0][i]);
            fillOcean(heights,atlantic,heights.length-1,i,heights[heights.length-1][i]);
        }
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    finalList.add(Arrays.asList(i,j));
                }
            }
        }
        return finalList;



    }
    private void fillOcean(int[][] heights,boolean[][] ocean,int row,int col,int prev){
        if(row<0 || col<0 || row>=heights.length || col>=heights[0].length){
            return;
        }
        if(ocean[row][col]){
            return;
        }
        if(heights[row][col]<prev){
            return;
        }
        ocean[row][col] = true;
        fillOcean(heights,ocean,row+1,col,heights[row][col]);
          fillOcean(heights,ocean,row-1,col,heights[row][col]);
            fillOcean(heights,ocean,row,col+1,heights[row][col]);
              fillOcean(heights,ocean,row,col-1,heights[row][col]);
    }
}
