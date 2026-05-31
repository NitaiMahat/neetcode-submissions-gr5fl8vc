class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null){
            return null;
        }
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights[0].length;i++){
            dfs(heights,pacific,0,i,heights[0][i]);
            dfs(heights,atlantic,heights.length-1,i,heights[heights.length-1][i]);
        }
        for(int i =0; i<heights.length;i++){
            dfs(heights,pacific,i,0,heights[i][0]);
            dfs(heights,atlantic,i,heights[0].length-1,heights[i][heights[0].length-1]);
        }
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    finalList.add(temp);
                }
            }
        }
        return finalList;
    }
    private void dfs(int[][] heights , boolean[][] ocean , int row,int col,int prev){
        if(row<0 || col <0 || row>= heights.length || col >=heights[0].length || prev > heights[row][col]){
            return;
        }
        if(ocean[row][col]){
            return;
        }
        ocean[row][col] = true;
        dfs(heights,ocean,row-1,col,heights[row][col]);
        dfs(heights,ocean,row,col+1,heights[row][col]);
        dfs(heights,ocean,row+1,col,heights[row][col]);
        dfs(heights,ocean,row,col-1,heights[row][col]);
    }
}
