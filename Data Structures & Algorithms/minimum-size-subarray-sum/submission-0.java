class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minSize = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}