/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        if(intervals.size() == 0){
            return true;
        }
        Interval currentInterval = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval nextInterval = intervals.get(i);
            if(currentInterval.end > nextInterval.start){
                return false;
            }
            currentInterval = nextInterval;
        }
        return true;

    }
}
