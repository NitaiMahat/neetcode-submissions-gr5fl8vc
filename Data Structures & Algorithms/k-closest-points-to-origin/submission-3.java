class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int ans = x*x + y*y;
            queue.add(new int[]{x,y,ans});
        }
        int[][] finalArr = new int[k][2];
        for(int i=0;i<k;i++){
            int[] curr = queue.poll();
            
            finalArr[i][0] = curr[0];
            finalArr[i][1] = curr[1];
        }
        return finalArr;

    }
}
