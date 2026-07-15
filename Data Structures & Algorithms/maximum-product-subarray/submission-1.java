class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(current, curMax * current);
            curMin = Math.min(current, curMin * current);

            maxProduct = Math.max(maxProduct, curMax);
        }

        return maxProduct;
    }
}
