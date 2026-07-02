class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        backtrack(0, n, board, result, cols, mainDiag, antiDiag);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result,
        boolean[] cols, boolean[] mainDiag, boolean[] antiDiag) {
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int main = row - col + n - 1;
            int anti = row + col;

            if (cols[col] || mainDiag[main] || antiDiag[anti])
                continue;
            board[row][col] = 'Q';
            cols[col] = true;
            mainDiag[main] = true;
            antiDiag[anti] = true;

            backtrack(row + 1, n, board, result, cols, mainDiag, antiDiag);

            board[row][col] = '.';
            cols[col] = false;
            mainDiag[main] = false;
            antiDiag[anti] = false;
        }
    }

    private List<String> buildBoard(char[][] board) {
        List<String> result = new ArrayList<>();

        for (char[] row : board) {
            result.add(new String(row));
        }

        return result;
    }
}
