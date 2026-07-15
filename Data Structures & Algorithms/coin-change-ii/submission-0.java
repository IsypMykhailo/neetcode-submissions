class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[coins.length][amount + 1];
        return calculateChangeCombinations(coins, amount, 0, cache);
    }

    private int calculateChangeCombinations (int[] coins, int amount, int i, Integer[][] cache) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;

        if (cache[i][amount] != null) return cache[i][amount];

        int skipCoin = calculateChangeCombinations(coins, amount, i + 1, cache);
        int repeatCoin = calculateChangeCombinations(coins, amount - coins[i], i, cache);

        cache[i][amount] = skipCoin + repeatCoin;
        return cache[i][amount];
    }
}
