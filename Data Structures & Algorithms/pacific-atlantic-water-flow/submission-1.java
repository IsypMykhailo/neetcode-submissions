class Solution {
    Set<List<Integer>> pacific = new HashSet();
    Set<List<Integer>> atlantic = new HashSet();
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] visitedPacific = new boolean[rows][cols];
        boolean[][] visitedAtlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, visitedPacific, true);
            dfs(heights, i, cols - 1, visitedAtlantic, false);
        }

        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, visitedPacific, true);
            dfs(heights, rows - 1, i, visitedAtlantic, false);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                List<Integer> coords = new ArrayList();
                coords.add(i);
                coords.add(j);
                if (pacific.contains(coords) && atlantic.contains(coords)) {
                    result.add(coords);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, boolean isPacific) {
        if (!isValidCoord(grid, r, c) || visited[r][c])
            return;

        visited[r][c] = true;
        List<Integer> coords = new ArrayList();
        coords.add(r);
        coords.add(c);
        if (isPacific) {
            pacific.add(coords);
        } else {
            atlantic.add(coords);
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = r + ROW_DIRECTIONS[i];
            int nextCol = c + COL_DIRECTIONS[i];

            if (isValidCoord(grid, nextRow, nextCol) && grid[nextRow][nextCol] >= grid[r][c]) {
                dfs(grid, nextRow, nextCol, visited, isPacific);
            }
        }
    }

    private boolean isValidCoord(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
