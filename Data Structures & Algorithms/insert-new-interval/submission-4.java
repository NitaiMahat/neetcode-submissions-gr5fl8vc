class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
            left insert right
        **/
        int[][] ans = new int[intervals.length+1][2];
        int idx = 0;
        int i = 0;
        //left
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            ans[idx] = intervals[i];
            idx++;
            i++;
        }
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans[idx] = newInterval;
        idx++;
        while(i<intervals.length){
            ans[idx] = intervals[i];
            idx++;
            i++;
        }
        return Arrays.copyOf(ans,idx);
    }
}
