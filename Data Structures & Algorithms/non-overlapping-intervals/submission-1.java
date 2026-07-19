class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
          Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int kept = 1;
        int prevEnd = intervals[0][1];
       
        int idx = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >=prevEnd){
                kept++;
                prevEnd = intervals[i][1];

            }
           
        }
       
        return  intervals.length-kept;
    }
}
