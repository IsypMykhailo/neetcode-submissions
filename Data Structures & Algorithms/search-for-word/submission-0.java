class Solution {
    record Point(int row, int col) {}

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i, j, 0, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(
        char[][] board,
        String word,
        int row,
        int col,
        int currentIndex,
        Set<Point> seen
    ) {
        if (currentIndex == word.length()) {
            return true;
        }

        if (
            row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length ||
            seen.contains(new Point(row, col)) ||
            board[row][col] != word.charAt(currentIndex)
        ) {
            return false;
        }

        Point current = new Point(row, col);
        seen.add(current);

        boolean found =
            backtrack(board, word, row + 1, col, currentIndex + 1, seen) ||
            backtrack(board, word, row - 1, col, currentIndex + 1, seen) ||
            backtrack(board, word, row, col + 1, currentIndex + 1, seen) ||
            backtrack(board, word, row, col - 1, currentIndex + 1, seen);

        seen.remove(current);

        return found;
    }
}
