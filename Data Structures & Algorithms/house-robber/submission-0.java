class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        return dfs(0, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] > 0) return memo[i];

        memo[i] = Math.max(nums[i] + dfs(i + 2, nums, memo), dfs(i + 1, nums, memo));
        return memo[i];
    }
}
