class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public int swimInWater(int[][] grid) {
        int[][] dist = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curRow = current[0];
            int curCol = current[1];
            int curTime = current[2];

            if (curTime > dist[curRow][curCol])
                continue;

            if (curRow == grid.length - 1 && curCol == grid.length - 1)
                return curTime;

            for (int d = 0; d < 4; d++) {
                int newRow = curRow + ROW_DIRECTIONS[d];
                int newCol = curCol + COL_DIRECTIONS[d];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length) {
                    int newTime = Math.max(curTime, grid[newRow][newCol]);

                    if (newTime < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newTime;
                        pq.add(new int[] {newRow, newCol, newTime});
                    }
                }
            }
        }

        return -1;
    }
}
