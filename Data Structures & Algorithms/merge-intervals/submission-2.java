class Solution {
    public int[][] merge(int[][] intervals) {
        /**
            1,3 -> 1,5  6,7
            sort
            prev interval
            start from 1 and comapre

        **/
        int[][] nonOverlappingArr = new int[intervals.length][intervals[0].length];
        int idx = 0;
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int prevStart =intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(prevEnd >= currStart){
                prevEnd = Math.max(currEnd,prevEnd);
                prevStart = Math.min(currStart,prevStart);

            }else{
                nonOverlappingArr[idx][0] = prevStart;
                nonOverlappingArr[idx][1] = prevEnd;
                idx++;

                prevStart = currStart;
                prevEnd = currEnd;
            }  
        }
        nonOverlappingArr[idx][0] = prevStart;
        nonOverlappingArr[idx][1] = prevEnd;
        idx++;
        return Arrays.copyOf(nonOverlappingArr,idx);

        
    }
}
