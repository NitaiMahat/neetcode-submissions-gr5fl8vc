class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        int[][] ans = new int[intervals.length][intervals[0].length];
        int idx = 0;
        for(int i=1;i<intervals.length;i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if(currentEnd >= newStart){
                currentEnd = Math.max(currentEnd,newEnd);

            }else{
                ans[idx][0] = currentStart;
                ans[idx][1] = currentEnd;
                idx++;
                currentStart = newStart;
                currentEnd = newEnd;
            }
        }
        ans[idx][0] = currentStart;
        ans[idx][1] = currentEnd;
        idx++;
        return Arrays.copyOf(ans,idx);
    }
}
