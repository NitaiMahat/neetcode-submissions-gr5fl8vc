class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights==null || heights.length==0){
            return 0;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        queue.add(new int[] {0,0,0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int effort = curr[2];
            if(row==heights.length-1 && col == heights[0].length-1){
                return effort;
            }
            if(visited[row][col]){
                continue;
            }
            visited[row][col] = true;
        
            calcEffort(heights,queue,row-1,col,curr);
            calcEffort(heights,queue,row+1,col,curr);
            calcEffort(heights,queue,row,col-1,curr);
            calcEffort(heights,queue,row,col+1,curr);
        }
        return 0;

    }
    private void calcEffort(int[][] heights, PriorityQueue<int[]> queue, int row , int col, int[] curr){
        if(row<0 || col <0 || row >= heights.length || col>=heights[0].length){
            return;
        }
        int newEdge = Math.abs(heights[row][col]-heights[curr[0]][curr[1]]);
        int newEffort =Math.max(curr[2],newEdge);
        queue.add(new int[] {row,col,newEffort});
    }
}