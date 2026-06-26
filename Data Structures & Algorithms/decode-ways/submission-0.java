class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        return decode(0, s, memo);
    }

    private int decode(int i, String s, int[] memo) {
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        if (memo[i] > 0) return memo[i];

        int ways = decode(i + 1, s, memo);

        if (i + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));

            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += decode(i + 2, s, memo);
            }
        }

        memo[i] = ways;
        return memo[i];
    }
}
