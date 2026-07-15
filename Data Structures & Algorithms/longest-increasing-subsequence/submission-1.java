class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int curLongest = findLongest(nums, cache, i);

            longest = Math.max(longest, curLongest);
        }

        return longest;
    }

    private int findLongest(int[] nums, int[] cache, int i) {
        if (cache[i] != 0) return cache[i];
        int longest = 1;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                int curLongest = 1 + findLongest(nums, cache, j);
                longest = Math.max(longest, curLongest);
            }
        }

        cache[i] = longest;
        return cache[i];
    }
}
