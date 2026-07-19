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
       Collections.sort(intervals,(a,b) -> a.start-b.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for(Interval interval : intervals){
            if(!queue.isEmpty() && queue.peek() > interval.start){
                return false;
            }
            queue.add(interval.end);
        }
        return true;
    }
}
