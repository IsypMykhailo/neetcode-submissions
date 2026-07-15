class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] cache = new Integer[text1.length()][text2.length()];
        return getLongest(text1.toCharArray(), text2.toCharArray(), 0, 0, cache);
    }

    private int getLongest(char[] text1, char[] text2, int i, int j, Integer[][] cache) {
        if (i == text1.length || j == text2.length) return 0;
        
        if (cache[i][j] != null) return cache[i][j];

        if (text1[i] == text2[j]) {
            cache[i][j] = 1 + getLongest(text1, text2, i + 1, j + 1, cache);
            return cache[i][j];
        }

        int increaseText1 = getLongest(text1, text2, i + 1, j, cache);
        int increaseText2 = getLongest(text1, text2, i, j + 1, cache);

        cache[i][j] = Math.max(increaseText1, increaseText2);
        return cache[i][j];
    }
}
