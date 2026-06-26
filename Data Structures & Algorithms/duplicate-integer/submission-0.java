class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                return true;
            }
            freq.put(nums[i], 1);
        }

        return false;
    }
}