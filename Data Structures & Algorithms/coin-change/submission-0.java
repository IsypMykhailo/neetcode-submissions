class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = Integer.MAX_VALUE;
        }
        cache[0] = 0;

        return getMinCoins(coins, cache, amount);
    }

    private int getMinCoins(int[] coins, int[] cache, int currentAmount) {
        if (cache[currentAmount] != Integer.MAX_VALUE) {
            return cache[currentAmount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= currentAmount) {
                int result = getMinCoins(
                    coins,
                    cache,
                    currentAmount - coin
                );

                if (result != -1) {
                    minCoins = Math.min(minCoins, 1 + result);
                }
            }
        }

        cache[currentAmount] =
            minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        return cache[currentAmount];
    }
}
