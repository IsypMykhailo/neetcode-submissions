class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] cache = new Integer[word1.length()][word2.length()];
        return calculateMinDistance(word1, word2, 0, 0, cache);
    }

    private int calculateMinDistance(String word1, String word2, int i, int j, Integer[][] cache) {
        if (j == word2.length()) return word1.length() - i;
        if (i == word1.length()) return word2.length() - j;

        if (cache[i][j] != null) return cache[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            cache[i][j] = calculateMinDistance(word1, word2, i + 1, j + 1, cache);
            return cache[i][j];
        }

        int minInsert = 1 + calculateMinDistance(word1, word2, i, j + 1, cache);

        int minDelete = 1 + calculateMinDistance(word1, word2, i + 1, j, cache);

        int minReplace = 1 + calculateMinDistance(word1, word2, i + 1, j + 1, cache);

        cache[i][j] = Math.min(minInsert, Math.min(minDelete, minReplace));
        return cache[i][j];
    }
}
