class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] output = new int[queries.length];

        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[] {queries[i], i};
        }

        Arrays.sort(sortedQueries, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[0], b[0]));

        int intervalIndex = 0;

        for (int[] query : sortedQueries) {
            int value = query[0];
            int originalIndex = query[1];

            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= value) {
                int start = intervals[intervalIndex][0];
                int end = intervals[intervalIndex][1];
                int size = end - start + 1;

                queue.add(new int[] {size, end});
                intervalIndex++;
            }

            while (!queue.isEmpty() && queue.peek()[1] < value) {
                queue.poll();
            }

            output[originalIndex] = queue.isEmpty() ? -1 : queue.peek()[0];
        }

        return output;
    }
}
