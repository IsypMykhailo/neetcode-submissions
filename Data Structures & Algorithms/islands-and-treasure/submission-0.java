class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] currentCell = queue.poll();
                int currRow = currentCell[0];
                int currCol = currentCell[1];

                visited[currRow][currCol] = true;
                if (grid[currRow][currCol] == Integer.MAX_VALUE)
                    grid[currRow][currCol] = currentLevel;

                for (int d = 0; d < 4; d++) {
                    int newRow = currRow + ROW_DIRECTIONS[d];
                    int newCol = currCol + COL_DIRECTIONS[d];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol] && grid[newRow][newCol] == Integer.MAX_VALUE) {
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }

            currentLevel++;
        }
    }
}
