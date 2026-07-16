class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                result++;
            }
        }

        return result;
    }
}
