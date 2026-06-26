class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            arr1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            arr2[i - 1] = nums[i];
        }
        return Math.max(dfs(0, arr1, memo1), dfs(0, arr2, memo2));
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] > 0) return memo[i];

        memo[i] = Math.max(nums[i] + dfs(i + 2, nums, memo), dfs(i + 1, nums, memo));
        return memo[i];
    }
}
