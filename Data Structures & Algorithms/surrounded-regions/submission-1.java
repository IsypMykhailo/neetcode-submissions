class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0 && i < rows - 1 && j > 0 && j < cols - 1)
                    continue;
                if (board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int startRow, int startCol, char[][] board) {
        if (startRow < 0 || startRow >= board.length || startCol < 0 || startCol >= board[0].length
            || board[startRow][startCol] != 'O')
            return;

        board[startRow][startCol] = '#';

        dfs(startRow + 1, startCol, board);
        dfs(startRow - 1, startCol, board);
        dfs(startRow, startCol + 1, board);
        dfs(startRow, startCol - 1, board);
    }
}
