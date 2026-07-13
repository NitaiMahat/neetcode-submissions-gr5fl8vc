class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       
        //left mid right
        int[][] ans = new int[intervals.length+1][2];
        
        int i=0;
        int j=0;
        //left;
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            ans[j] = intervals[i];
            i++;
            j++;
        }

        //mid
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }

        ans[j] =newInterval;
        j++;
        //right
        while(i<intervals.length){
            ans[j] = intervals[i];
            j++;
            i++;
        }
        return Arrays.copyOf(ans,j);
        
    }
}
