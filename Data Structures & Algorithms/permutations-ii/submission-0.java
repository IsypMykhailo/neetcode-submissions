class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, result);

        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);

            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            backtrack(start + 1, nums, result);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
}