class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : weights) {
            sum += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int left = maxWeight;
        int right = sum;
        int result = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int daysNum = 1;
            int currentLoad = 0;
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    daysNum++;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }

            if (daysNum <= days) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}