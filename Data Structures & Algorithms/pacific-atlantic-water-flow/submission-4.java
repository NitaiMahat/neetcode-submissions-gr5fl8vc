class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> finalList = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
       for(int i=0;i<heights.length;i++){
        dfs(heights,i,0,pacific,heights[i][0]);
        dfs(heights,i,heights[0].length-1,atlantic,heights[i][heights[0].length-1]);
       }
       for(int i=0;i<heights[0].length;i++){
        dfs(heights,0,i,pacific,heights[0][i]);
        dfs(heights,heights.length-1,i,atlantic,heights[heights.length-1][i]);
       }
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j]== true && atlantic[i][j]==true){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    finalList.add(tempList);
                }
            }
        }
        return finalList;

    }
    private void dfs(int[][] heights, int row,int col, boolean[][] ocean,int prev){
        if(row <0 || col <0 || row >= heights.length || col >= heights[0].length || prev > heights[row][col]){
            return;
        }
        if (ocean[row][col]){
            return;
        }
        ocean[row][col] = true;

        dfs(heights,row+1,col,ocean, heights[row][col]);
        dfs(heights,row-1,col,ocean, heights[row][col]);
        dfs(heights,row,col+1,ocean, heights[row][col]);
        dfs(heights,row,col-1,ocean, heights[row][col]);
    }
}
