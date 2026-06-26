class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int rob = 0;
        int skip = 0;

        for (int i = start; i <= end; i++) {
            int newRob = skip + nums[i];
            int newSkip = Math.max(skip, rob);

            rob = newRob;
            skip = newSkip;
        }

        return Math.max(rob, skip);
    }
}
