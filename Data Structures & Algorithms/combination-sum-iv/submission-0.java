class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] cache = new Integer[target + 1];
        return calculateCombinations(nums, target, cache);
    }

    private int calculateCombinations(int[] nums, int target, Integer[] cache) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if (cache[target] != null) return cache[target];
        int numWays = 0;
        for (int j = 0; j < nums.length; j++) {
            numWays += calculateCombinations(nums, target - nums[j], cache);
        }

        cache[target] = numWays;
        return cache[target];
    }
}