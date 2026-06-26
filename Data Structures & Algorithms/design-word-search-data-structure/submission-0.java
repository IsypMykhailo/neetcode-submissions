class WordDictionary {
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

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null) return;

        TrieNode current = root;
        for (Character ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, k -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        if (word == null) return false;

        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEndOfWord();
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode childNode : node.getChildren().values()) {
                if (dfs(childNode, word, index + 1)) {
                    return true; 
                }
            }
            return false; 
        } 
        
        else {
            TrieNode nextNode = node.getChildren().get(ch);
            if (nextNode == null) {
                return false; 
            }
            return dfs(nextNode, word, index + 1);
        }
    }
}
