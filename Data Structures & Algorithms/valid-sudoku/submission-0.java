class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> columnSet = new HashSet();
        Set<Character> rowSet = new HashSet();
        List<Set<Character>> squares = new ArrayList();
        for (int i = 0; i < 9; i++) {
            squares.add(new HashSet<Character>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (columnSet.contains(board[i][j])) {
                    return false;
                }
                if (rowSet.contains(board[j][i])) {
                    return false;
                }
                int squareIdx = (i / 3) * 3 + (j / 3);
                if (squares.get(squareIdx).contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    columnSet.add(board[i][j]);
                    squares.get(squareIdx).add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    rowSet.add(board[j][i]);
                }
            }
            columnSet.clear();
            rowSet.clear();
        }

        return true;
    }
}
