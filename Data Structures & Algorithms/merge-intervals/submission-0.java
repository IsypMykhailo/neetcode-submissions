class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                int end = Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
                result.get(result.size() - 1)[1] = end;
            } else {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
