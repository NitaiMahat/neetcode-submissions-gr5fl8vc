class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(heights==null){
            return finalList;
        }
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] antlantic = new boolean[row][col];

        //dfs
       
        for(int j=0;j<col;j++){
                dfs(heights,0,j,Integer.MIN_VALUE,pacific);
                dfs(heights,row-1,j,Integer.MIN_VALUE,antlantic);
            }
        
        for(int i=0;i<row;i++){
                dfs(heights,i,0,Integer.MIN_VALUE,pacific);
                dfs(heights,i,col-1,Integer.MIN_VALUE,antlantic);
            }
        

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && antlantic[i][j]){
                    finalList.add(Arrays.asList(i,j));
                }
            }
        }
        return finalList;
}
    
    private void dfs(int[][] heights, int row,int col, int prev, boolean[][] ocean){
        if(row<0 || col <0 || row > heights.length-1 || col > heights[0].length-1){
            return;
        }
        if(ocean[row][col] || heights[row][col] < prev){
            return;
        }
        ocean[row][col] = true;
        dfs(heights,row-1,col,heights[row][col],ocean);
        dfs(heights,row+1,col,heights[row][col],ocean);
        dfs(heights,row,col-1,heights[row][col],ocean);
        dfs(heights,row,col+1,heights[row][col],ocean);
    }
}
