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
        if (intervals.size() == 0) return true;
        intervals.sort((Interval a, Interval b) -> Integer.compare(a.start, b.start));

        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < prevEnd) {
                return false;
            } else {
                prevEnd = intervals.get(i).end;
            }
        }

        return true;
    }
}
