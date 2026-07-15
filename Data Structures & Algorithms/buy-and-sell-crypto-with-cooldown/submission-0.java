class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] cache = new Integer[prices.length][2];
        return getMaxProfit(prices, 0, 0, cache);
    }
    
    private int getMaxProfit(int[] prices, int i, int own, Integer[][] cache) {
        if (i >= prices.length) return 0;

        if (cache[i][own] != null) return cache[i][own];

        if (own == 1) {
            int maxKeep = getMaxProfit(prices, i + 1, 1, cache);
            int maxSell = prices[i] + getMaxProfit(prices, i + 2, 0, cache);
            cache[i][own] = Math.max(maxKeep, maxSell);
            return cache[i][own];
        }

        int maxSkip = getMaxProfit(prices, i + 1, 0, cache);
        int maxBuy = -prices[i] + getMaxProfit(prices, i + 1, 1, cache);
        cache[i][own] = Math.max(maxSkip, maxBuy);
        return cache[i][own];
    }
}
