class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = prices.clone();
            boolean anyChange = false;

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (prices[from] != Integer.MAX_VALUE && prices[from] + price < temp[to]) {
                    temp[to] = prices[from] + price;
                    anyChange = true;
                }
            }

            prices = temp;

            if (!anyChange) break;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
