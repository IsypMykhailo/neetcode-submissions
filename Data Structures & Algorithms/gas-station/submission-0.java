class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1;

        int startingIndex = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            if (totalGas < 0) {
                totalGas = 0;
                startingIndex = i + 1;
            }
        }

        return startingIndex;
    }
}
