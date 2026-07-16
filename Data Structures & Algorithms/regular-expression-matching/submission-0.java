class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];
        return isMatchRec(s.toCharArray(), p.toCharArray(), 0, 0, cache);
    }

    private boolean isMatchRec(char[] s, char[] p, int i, int j, Boolean[][] cache) {
        if (j == p.length) return i == s.length;

        if (cache[i][j] != null) return cache[i][j];

        boolean firstMatches =
            i < s.length &&
            (s[i] == p[j] || p[j] == '.');

        boolean hasStar =
            j + 1 < p.length &&
            p[j + 1] == '*';

        if (hasStar) {
            boolean skipPattern = isMatchRec(s, p, i, j + 2, cache);

            boolean usePattern =
                firstMatches &&
                isMatchRec(s, p, i + 1, j, cache);

            cache[i][j] = skipPattern || usePattern;
            return cache[i][j];
        }

        if (firstMatches) {
            cache[i][j] = isMatchRec(s, p, i + 1, j + 1, cache);
            return cache[i][j];
        }

        cache[i][j] = false;
        return cache[i][j];
    }
}
