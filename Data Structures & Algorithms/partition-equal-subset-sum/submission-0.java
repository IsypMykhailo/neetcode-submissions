class Solution {
    public boolean canPartition(int[] nums) {
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }

        if (numsSum % 2 != 0)
            return false;

        Boolean[][] cache = new Boolean[nums.length][numsSum / 2 + 1];
        return halfSumExists(nums, numsSum / 2, cache, 0);
    }

    private boolean halfSumExists(int[] nums, int halfSum, Boolean[][] cache, int start) {
        if (halfSum == 0)
            return true;

        if (start == nums.length) {
            return false;
        }

        if (cache[start][halfSum] != null)
            return cache[start][halfSum];

        boolean skip = halfSumExists(nums, halfSum, cache, start + 1);

        boolean take = false;

        if (nums[start] <= halfSum) {
            take = halfSumExists(nums, halfSum - nums[start], cache, start + 1);
        }

        cache[start][halfSum] = take || skip;
        return cache[start][halfSum];
    }
}
