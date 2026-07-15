class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }
        Integer[][] cache = new Integer[nums.length][2 * arraySum + 1];
        return calculateTargetSumWays(nums, target, 0, 0, cache, arraySum);
    }

    private int calculateTargetSumWays(int[] nums, int target, int curSum, int i, Integer[][] cache, int offset) {
        if (i == nums.length) {
            if (curSum == target) return 1;
            else return 0;
        }

        int curSumIdx = curSum + offset;

        if (cache[i][curSumIdx] != null) return cache[i][curSumIdx];

        int addNum = calculateTargetSumWays(nums, target, curSum + nums[i], i + 1, cache, offset);
        int subNum = calculateTargetSumWays(nums, target, curSum - nums[i], i + 1, cache, offset);

        cache[i][curSumIdx] = addNum + subNum;
        return cache[i][curSumIdx];
    }
}
