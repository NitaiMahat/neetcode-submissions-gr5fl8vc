class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         if(heights==null || heights.length==0){
            return result;
         }
         ROWS = heights.length;
         COLS = heights[0].length;
        List<Integer> temp = new ArrayList<>();

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int i=0;i<ROWS;i++){
            dfs(heights,i,COLS-1,Integer.MIN_VALUE,atl);
            dfs(heights,i,0,Integer.MIN_VALUE,pac);
        }
        for(int i=0;i<COLS;i++){
            dfs(heights,0,i,Integer.MIN_VALUE,pac);
            dfs(heights,ROWS-1,i,Integer.MIN_VALUE,atl);
        }
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(pac[i][j] && atl[i][j]){
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
                temp = new ArrayList<>();
            }
        }
        return result;



       
    }

    private void dfs(int[][] heights,int i,int j,int prev,boolean[][] ocean){
        if(i<0 || i >= ROWS || j <0 || j >=COLS || heights[i][j]<prev || ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        dfs(heights,i+1,j,heights[i][j],ocean);
        dfs(heights,i-1,j,heights[i][j],ocean);
        dfs(heights,i,j+1,heights[i][j],ocean);
        dfs(heights,i,j-1,heights[i][j],ocean);
    }
}
