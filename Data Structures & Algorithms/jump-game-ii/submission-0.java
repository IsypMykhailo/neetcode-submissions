class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int farthestIndex = 0;
        int numSteps = 0;
        while (right < nums.length - 1) {
            for (int i = left; i <= right; i++) {
                farthestIndex = Math.max(farthestIndex, i + nums[i]);
            }
            left = right + 1;
            right = farthestIndex;
            numSteps++;
        }

        return numSteps;
    }
}
