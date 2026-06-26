class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairsRec(n, memo);
    }

    private int climbStairsRec(int n, int[] memo) {
        if (n <= 2) return n;
        if(memo[n] > 0) return memo[n];

        memo[n] = climbStairsRec(n - 1, memo) + climbStairsRec(n - 2, memo);
        return memo[n];
    }
}
