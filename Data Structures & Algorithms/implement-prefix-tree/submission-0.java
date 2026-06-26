class PrefixTree {
    class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap();
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

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        TrieNode current = root;
        for (Character ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        TrieNode current = root;
        for (Character ch : word.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        TrieNode current = root;
        for (Character ch : prefix.toCharArray()) {
            current = current.getChildren().get(ch);
            if (current == null) {
                return false;
            }
        }

        return true;
    }
}
