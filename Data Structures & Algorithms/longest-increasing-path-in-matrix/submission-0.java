class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] cache = new Integer[m][n];
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, calculateLongestIncreasingPath(matrix, m, n, i, j, cache));
            }
        }

        return longest;
    }

    private int calculateLongestIncreasingPath(int[][] matrix, int m, int n, int row, int col, Integer[][] cache) {
        if (cache[row][col] != null) return cache[row][col];
        int longest = 1;

        for (int d = 0; d < 4; d++) {
            int nextRow = row + ROW_DIRECTIONS[d];
            int nextCol = col + COL_DIRECTIONS[d];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && matrix[row][col] < matrix[nextRow][nextCol]) {
                longest = Math.max(longest, 1 + calculateLongestIncreasingPath(matrix, m, n, nextRow, nextCol, cache));
            }
        }

        cache[row][col] = longest;

        return cache[row][col];
    }
}
