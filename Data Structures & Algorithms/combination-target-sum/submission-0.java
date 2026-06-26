class Solution {
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, 0, new ArrayList<Integer>(), nums, target);

        return result;
    }

    private void backtrack(int currentSum, int currentIndex, List<Integer> currentPath, int[] nums, int target) {
        if (currentSum == target) {
            result.add(new ArrayList(currentPath));
            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {
            if (currentSum + nums[i] > target) continue;

            currentPath.add(nums[i]);
            currentSum += nums[i];

            backtrack(currentSum, i, currentPath, nums, target);

            currentPath.remove(currentPath.size() - 1);
            currentSum -= nums[i];
        }
    }
}
