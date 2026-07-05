class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) return 0;
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        return 1 + dfs(row + 1, col, grid) + dfs(row - 1, col, grid) + dfs(row, col + 1, grid) + dfs(row, col - 1, grid);
    }
}
