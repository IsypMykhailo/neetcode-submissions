class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length()];
        return checkBreak(0, s, wordDict, cache);
    }

    private boolean checkBreak(int i, String s, List<String> wordDict, Boolean[] cache) {
        if (i == s.length()) return true;

        if (cache[i] != null) return cache[i];

        for (String word : wordDict) {
            if (s.startsWith(word, i)) {
                boolean breaks = checkBreak(i + word.length(), s, wordDict, cache);
                if (breaks) {
                    cache[i] = true;
                    return true;
                }
            }
        }

        cache[i] = false;
        return false;
    }
}
