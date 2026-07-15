class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        int minCostStartZero = getMinCost(cost, cache, 0);
        int minCostStartOne = getMinCost(cost, cache, 1);

        return Math.min(minCostStartZero, minCostStartOne);
    }

    private int getMinCost(int[] cost, int[] cache, int currentFloor) {
        if (currentFloor > cost.length - 1) {
            return 0;
        }

        if (cache[currentFloor] != 0) return cache[currentFloor];

        int minCostOneStep = getMinCost(cost, cache, currentFloor + 1);
        int minCostTwoSteps = getMinCost(cost, cache, currentFloor + 2);
        cache[currentFloor] = cost[currentFloor] + Math.min(minCostOneStep, minCostTwoSteps);

        return cache[currentFloor];
    }
}
