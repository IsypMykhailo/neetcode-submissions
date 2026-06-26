class Solution {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;
        private int index;

        public TrieNode() {
            this.children = new HashMap();
            this.isEndOfWord = false;
            this.index = -1;
        }
        public Map<Character, TrieNode> getChildren() {
            return children;
        }
        public boolean isEndOfWord() {
            return isEndOfWord;
        }
        public void setEndOfWord(boolean isEndOfWord) {
            this.isEndOfWord = isEndOfWord;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word, int index) {
        if (word == null) {
            return;
        }

        TrieNode current = root;
        for (Character ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }
        current.setEndOfWord(true);
        current.setIndex(index);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                backtrack(board, words, root, i, j, result);
            }
        }

        return result;
    }

    private void backtrack(
        char[][] board, String[] words, TrieNode current, int row, int col, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        if (!current.getChildren().containsKey(ch)) {
            return;
        }

        TrieNode nextNode = current.getChildren().get(ch);

        if (nextNode.isEndOfWord()) {
            result.add(words[nextNode.getIndex()]);
            nextNode.setEndOfWord(false);
            nextNode.setIndex(-1);
        }

        board[row][col] = '#';

        backtrack(board, words, nextNode, row + 1, col, result);
        backtrack(board, words, nextNode, row - 1, col, result);
        backtrack(board, words, nextNode, row, col + 1, result);
        backtrack(board, words, nextNode, row, col - 1, result);

        board[row][col] = ch;
    }
}
