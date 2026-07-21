class Solution {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
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
    }

    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            TrieNode current = root;
            for (Character ch : word.toCharArray()) {
                current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
            }
            current.setEndOfWord(true);
        }

        Integer[] memo = new Integer[s.length()];

        return dfs(root, s, 0, memo);
    }

    private int dfs(TrieNode node, String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int minExtra = 1 + dfs(node, s, index + 1, memo);

        TrieNode current = node;

        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!current.getChildren().containsKey(ch)) {
                break;
            }

            current = current.getChildren().get(ch);

            if (current.isEndOfWord()) {
                minExtra = Math.min(
                    minExtra, dfs(node, s, i + 1, memo)
                );
            }
        }

        memo[index] = minExtra;

        return minExtra;
    }
}