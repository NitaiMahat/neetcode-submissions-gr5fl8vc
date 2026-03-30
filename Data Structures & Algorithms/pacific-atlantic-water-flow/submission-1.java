class Solution {
    int ROWS;
    int COLS;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<Integer> temp = new ArrayList<>();
        if(heights==null || heights.length==0){
            return result;
        }
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int i=0;i<ROWS;i++){
                dfs(heights,temp,Integer.MIN_VALUE,i,0,pac);
                dfs(heights,temp,Integer.MIN_VALUE,i,COLS-1,atl);
        }
        for(int i=0;i<COLS;i++){
            dfs(heights,temp,Integer.MIN_VALUE,0,i,pac);
            dfs(heights,temp,Integer.MIN_VALUE,ROWS-1,i,atl);
        }

        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(pac[i][j]&&atl[i][j]){
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
                temp = new ArrayList<>();
            }
        }
        return result;

        

    }
    private void dfs(int[][] heights, List<Integer> temp, int prev, int i,int j,boolean[][] ocean){
        if(i<0 || i >=ROWS || j <0 || j >= COLS || heights[i][j] < prev ||ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        dfs(heights,temp,heights[i][j],i+1,j,ocean);
        dfs(heights,temp,heights[i][j],i-1,j,ocean);
        dfs(heights,temp,heights[i][j],i,j+1,ocean);
        dfs(heights,temp,heights[i][j],i,j-1,ocean);

    }
}
