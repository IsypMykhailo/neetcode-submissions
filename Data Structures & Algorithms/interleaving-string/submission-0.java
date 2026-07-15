class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] cache = new Boolean[s1.length() + 1][s2.length() + 1];

        return findInterleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, cache);
    }

    private boolean findInterleave(char[] s1, char[] s2, char[] s3, int i, int j, Boolean[][] cache) {
        int k = i + j;
        if (k == s3.length) {
            return true;
        }

        if (cache[i][j] != null) return cache[i][j];

        boolean canInterleave = false;

        if (i < s1.length && s1[i] == s3[k]) {
            canInterleave = findInterleave(s1, s2, s3, i + 1, j, cache);
        }

        if (!canInterleave && j < s2.length && s2[j] == s3[k]) {
            canInterleave = findInterleave(s1, s2, s3, i, j + 1, cache);
        }

        cache[i][j] = canInterleave;
        return canInterleave;
    }
}
