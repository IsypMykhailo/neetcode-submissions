class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return calculatePaths(0, 0, m, n, cache);
    }

    private int calculatePaths(int startRow, int startCol, int m, int n, int[][] cache) {
        if (startRow == m - 1 && startCol == n - 1) {
            return 1;
        }

        if (cache[startRow][startCol] != 0)
            return cache[startRow][startCol];

        int below = 0;
        int right = 0;

        if (startRow + 1 < m)
            below = calculatePaths(startRow + 1, startCol, m, n, cache);

        if (startCol + 1 < n)
            right = calculatePaths(startRow, startCol + 1, m, n, cache);

        cache[startRow][startCol] = below + right;
        return cache[startRow][startCol];
    }
}
