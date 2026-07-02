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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Interval meetings: intervals){
            if(!minHeap.isEmpty() && meetings.start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(meetings.end);
        }
        return minHeap.size();
    }
}
