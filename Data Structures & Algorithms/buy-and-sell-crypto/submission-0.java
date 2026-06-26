class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int minBuy = 0;
            for (int j = 1; j < i; j++) {
                if (prices[j] < prices[minBuy]) {
                    minBuy = j;
                }
            }
            int profit = prices[i] - prices[minBuy];
            if (profit > max) {
                max = profit;
            }
        }

        return max;
    }
}
