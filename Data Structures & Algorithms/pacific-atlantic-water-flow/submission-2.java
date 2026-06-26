class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, cols - 1, atlantic);
        }

        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, rows - 1, j, atlantic);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (!isValidCoord(grid, r, c) || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = r + ROW_DIRECTIONS[i];
            int nextCol = c + COL_DIRECTIONS[i];

            if (
                isValidCoord(grid, nextRow, nextCol) &&
                grid[nextRow][nextCol] >= grid[r][c]
            ) {
                dfs(grid, nextRow, nextCol, visited);
            }
        }
    }

    private boolean isValidCoord(int[][] grid, int row, int col) {
        return row >= 0 &&
               row < grid.length &&
               col >= 0 &&
               col < grid[0].length;
    }
}
