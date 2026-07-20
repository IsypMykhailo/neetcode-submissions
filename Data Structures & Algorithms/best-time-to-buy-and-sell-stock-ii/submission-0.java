class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] cache = new Integer[prices.length][2];
        return calculateProfit(prices, 0, 0, cache);
    }

    private int calculateProfit(int[] prices, int i, int own, Integer[][] cache) {
        if (i == prices.length) return 0;

        if (cache[i][own] != null) return cache[i][own];

        if (own == 1) {
            int sell = prices[i] + calculateProfit(prices, i + 1, 0, cache);
            int hold = calculateProfit(prices, i + 1, 1, cache);
            cache[i][own] = Math.max(sell, hold);
            return cache[i][own];
        } else {
            int buy = -prices[i] + calculateProfit(prices, i + 1, 1, cache);
            int skip = calculateProfit(prices, i + 1, 0, cache);
            cache[i][own] = Math.max(buy, skip);
            return cache[i][own];
        }
    }
}