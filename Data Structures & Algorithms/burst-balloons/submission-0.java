class Solution {
    public int maxCoins(int[] nums) {
        int[] paddedArr = new int[nums.length + 2];
        paddedArr[0] = 1;
        paddedArr[paddedArr.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            paddedArr[i + 1] = nums[i];
        }
        Integer[][] cache = new Integer[paddedArr.length][paddedArr.length];
        return calculateMaxCoins(paddedArr, 0, paddedArr.length - 1, cache);
    }

    private int calculateMaxCoins(int[] nums, int left, int right, Integer[][] cache) {
        if (left + 1 == right) return 0;
        if (cache[left][right] != null) return cache[left][right];
        int maxCoins = 0;
        for (int i = left + 1; i < right; i++) {
            int burstLast = nums[left] * nums[i] * nums[right];
            int burstLeft = calculateMaxCoins(nums, left, i, cache);
            int burstRight = calculateMaxCoins(nums, i, right, cache);

            int totalCoins = burstLeft + burstLast + burstRight;
            maxCoins = Math.max(maxCoins, totalCoins);
        }

        cache[left][right] = maxCoins;
        return cache[left][right];
    }
}
