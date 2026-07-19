class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int kept = 1;
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevEnd<= intervals[i][0] ){
                kept++;
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length-kept;

    }
}
