class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] cache = new Integer[s.length()][t.length()];
        return calculateDistinct(s.toCharArray(), t.toCharArray(), 0, 0, cache);
    }

    private int calculateDistinct(char[] s, char[] t, int i, int j, Integer[][] cache) {
        if (j == t.length) return 1;
        if (i == s.length) return 0;

        if (cache[i][j] != null) return cache[i][j];

        if (s[i] == t[j]) {
            int useLetter = calculateDistinct(s, t, i + 1, j + 1, cache);
            int skipLetter = calculateDistinct(s, t, i + 1, j, cache);
            cache[i][j] = useLetter + skipLetter;
            return cache[i][j];
        }

        cache[i][j] = calculateDistinct(s, t, i + 1, j, cache);
        return cache[i][j];
    }
}
