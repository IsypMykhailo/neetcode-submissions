class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), 0, result);
        return result;
    }

    private void backtrack(int start, int target, int[] candidates, List<Integer> current,
        int currentSum, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (currentSum + candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            currentSum += candidates[i];

            backtrack(i + 1, target, candidates, current, currentSum, result);

            currentSum -= current.get(current.size() - 1);
            current.remove(current.size() - 1);
        }
    }
}
