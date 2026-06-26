class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int groupsCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    groupsCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return groupsCount;
    }

    private void dfs(char[][] grid, int startRow, int startCol) {
        if (grid == null || grid.length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        dfsRecursive(grid, startRow, startCol, visited);
    }

    private void dfsRecursive(char[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = true;
        grid[r][c] = '0';

        for (int i = 0; i < 4; i++) {
            int nextRow = r + ROW_DIRECTIONS[i];
            int nextCol = c + COL_DIRECTIONS[i];

            dfsRecursive(grid, nextRow, nextCol, visited);
        }
    }
}
