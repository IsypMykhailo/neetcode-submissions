class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
        int result = calculatePaths(0, 0, m, n, cache);
        return result;
    }

    private boolean isValidPath(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    private int calculatePaths(int startRow, int startCol, int m, int n, int[][] cache) {
        if (startRow == m - 1 && startCol == n - 1) {
            return 1;
        }

        if (!isValidPath(startRow, startCol, m, n)) return 0;

        if (cache[startRow][startCol] != -1) return cache[startRow][startCol];

        int below = calculatePaths(startRow + 1, startCol, m, n, cache);
        int right = calculatePaths(startRow, startCol + 1, m, n, cache);

        cache[startRow][startCol] = below + right;
        return cache[startRow][startCol];
    }
}
